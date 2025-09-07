package net.oxcodsnet.roadencounters;

import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PatrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.Registries;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.oxcodsnet.roadarchitect.api.addon.AddonContext;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddon;
import net.oxcodsnet.roadencounters.storage.TriggerStorage;
import net.oxcodsnet.roadencounters.config.REConfig;
import net.oxcodsnet.roadencounters.config.EventKind;
import net.oxcodsnet.roadencounters.config.REConfigHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Ambush encounter addon for RoadArchitect. Places markers along finalized paths
 * and handles triggering on player proximity.
 */
public final class AmbushAddon implements RoadAddon {
    public static final String MOD_ID = "roadarchitect_roadencounters";
    public static final Identifier ADDON_ID = Identifier.of(MOD_ID, "ambush_addon");
    public static final Identifier AMBUSH_TRIGGER = Identifier.of(MOD_ID, "ambush");
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + "/AmbushAddon");

    private TriggerStorage storage;
    private REConfig config;

    @Override
    public Identifier id() {
        return ADDON_ID;
    }

    @Override
    public void onRegister() {
        // legacy hook (required by API); actual init happens in onRegister(AddonContext)
    }

    @Override
    public void onRegister(AddonContext ctx) {
        // init addon-local storage backed by RA PersistentStore
        this.storage = TriggerStorage.create(ctx::persistent, ctx.logger(), id());
        // resolve platform-backed config
        this.config = REConfigHolder.get();
        // info log for successful registration
        ctx.logger().info("[{}] Addon registered successfully", MOD_ID);
    }

    @Override
    public void onPathReady(ServerWorld world, String pathKey, List<BlockPos> refinedPath) {
        if (storage == null) return;
        if (refinedPath.size() < 16) return;
        int maxMarkers = config.maxMarkers();
        int stride = config.strideBlocks();
        int placed = 0;
        int acc = 0;
        for (int i = 1; i < refinedPath.size(); i++) {
            BlockPos a = refinedPath.get(i - 1);
            BlockPos b = refinedPath.get(i);
            int dx = Math.abs(b.getX() - a.getX());
            int dz = Math.abs(b.getZ() - a.getZ());
            int seg = Math.max(dx, dz);
            acc += seg;
            if (acc >= stride) {
                BlockPos p = b;
                storage.addMarker(world, p, AMBUSH_TRIGGER, config.triggerRadius(), new NbtCompound());
                placed++;
                if (placed >= maxMarkers) break;
                acc = 0;
            }
        }

        if (placed > 0) {
            LOGGER.debug("Ambush markers placed: {} on {}", placed, pathKey);
        }
    }

    @Override
    public void onServerTick(MinecraftServer server) {
        if (storage == null) return;
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (!(player.getWorld() instanceof ServerWorld world)) continue;
            // ensure chunk loaded to avoid triggering in void
            ChunkPos cp = new ChunkPos(player.getBlockPos());
            if (!world.isChunkLoaded(cp.x, cp.z)) continue;

            List<TriggerStorage.Marker> nearby = storage.findMarkersNear(world, player.getBlockPos(), config.triggerRadius());
            if (nearby.isEmpty()) continue;

            List<UUID> toRemove = new ArrayList<>();
            for (TriggerStorage.Marker m : nearby) {
                if (!world.isChunkLoaded(m.pos().getX() >> 4, m.pos().getZ() >> 4)) continue;
                handleTrigger(world, m.pos(), player);
                toRemove.add(m.id());
            }
            if (!toRemove.isEmpty()) {
                storage.markTriggered(world, toRemove, config.cooldownTicks());
            }
        }
    }

    @Override
    public void onChunkLoad(ServerWorld world, ChunkPos pos) {
        // no-op; storage lookup is lazy on demand
    }

    private void handleTrigger(ServerWorld world, BlockPos pos, ServerPlayerEntity player) {
        Random rnd = world.getRandom();
        var spec = pickEncounterSpec(config.encounterSpecs(), rnd);
        EventKind type = spec == null ? EventKind.AMBUSH : spec.eventType();
        switch (type) {
            case NONE -> { if (config.debugActionbar()) sendActionbar(player, "message.roadarchitect_roadencounters.none"); }
            case AMBUSH -> {
                if (world.getDifficulty() != Difficulty.PEACEFUL) {
                    handleEncounter(world, pos, spec);
                    if (config.debugActionbar()) sendActionbar(player, "message.roadarchitect_roadencounters.ambush");
                    playConfiguredSound(world, pos, EventKind.AMBUSH);
                }
            }
            case MERCHANT -> {
                handleEncounter(world, pos, spec);
                if (config.debugActionbar()) sendActionbar(player, "message.roadarchitect_roadencounters.merchant");
                playConfiguredSound(world, pos, EventKind.MERCHANT);
            }
            case PATROL -> {
                handleEncounter(world, pos, spec);
                if (config.debugActionbar()) sendActionbar(player, "message.roadarchitect_roadencounters.patrol");
                playConfiguredSound(world, pos, EventKind.PATROL);
            }
            case WILDLIFE -> {
                handleEncounter(world, pos, spec);
                if (config.debugActionbar()) sendActionbar(player, "message.roadarchitect_roadencounters.wildlife");
                playConfiguredSound(world, pos, EventKind.WILDLIFE);
            }
        }
    }

    // generic encounter spawner using EncounterSpec groups
    private void handleEncounter(ServerWorld world, BlockPos pos, REConfig.EncounterSpec spec) {
        if (spec == null) return;
        Random rnd = world.getRandom();
        for (var g : spec.groups()) {
            int count = Math.max(0, g.countMin()) + rnd.nextInt(Math.max(1, g.countMax() - g.countMin() + 1));
            for (int i = 0; i < count; i++) {
                int r = Math.max(2, config.spawnOffset());
                BlockPos p = findGround(world, pos.add(rnd.nextInt(r * 2 + 1) - r, 0, rnd.nextInt(r * 2 + 1) - r));
                EntityType<?> type = pickTypeFromIdOrTag(world, g.idOrTag(), rnd);
                if (type == null) type = EntityType.PILLAGER;
                Entity e = type.create(world);
                if (e == null) continue;

                // NBT processing
                if (g.nbt() != null && !g.nbt().isEmpty()) {
                    try {
                        var parsed = JsonParser.parseString(String.join("\n", g.nbt()));
                        NbtCompound nbt = (NbtCompound) JsonOps.INSTANCE.convertTo(NbtOps.INSTANCE, parsed);
                        NbtCompound existing = e.writeNbt(new NbtCompound());
                        existing.copyFrom(nbt);
                        e.readNbt(existing);
                    } catch (Exception ex) {
                        LOGGER.warn("Failed to apply NBT for encounter: {}", g.idOrTag(), ex);
                    }
                }

                if (e instanceof MobEntity me) {
                    me.initialize(world, world.getLocalDifficulty(p), SpawnReason.EVENT, null);
                    me.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                    world.spawnEntity(me);
                } else {
                    e.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                    world.spawnEntity(e);
                }
            }
        }
    }

    // treasure event removed

    private static void sendActionbar(ServerPlayerEntity player, String key) {
        player.sendMessage(Text.translatable(key), true);
    }

    private static REConfig.EncounterSpec pickEncounterSpec(java.util.List<REConfig.EncounterSpec> list, Random rnd) {
        if (list == null || list.isEmpty()) return null;
        int total = 0;
        for (var e : list) if (e.weight() > 0) total += e.weight();
        if (total <= 0) return list.get(0);
        int r = rnd.nextInt(total);
        int acc = 0;
        for (var e : list) {
            if (e.weight() <= 0) continue;
            acc += e.weight();
            if (r < acc) return e;
        }
        return list.get(0);
    }

    // kept for compatibility in case spec falls back; currently unused
    private void handleAmbush(ServerWorld world, BlockPos pos) {}

    private static EntityType<?> resolveEntityType(Identifier id) {
        if (id == null) return null;
        return Registries.ENTITY_TYPE.getOrEmpty(id).orElse(null);
    }

    private static EntityType<?> pickTypeFromIdOrTag(ServerWorld world, String idOrTag, Random rnd) {
        if (idOrTag == null || idOrTag.isEmpty()) return null;
        if (idOrTag.startsWith("#")) {
            try {
                var tagId = Identifier.tryParse(idOrTag.substring(1));
                if (tagId != null) {
                    var key = net.minecraft.registry.tag.TagKey.of(net.minecraft.registry.RegistryKeys.ENTITY_TYPE, tagId);
                    var list = Registries.ENTITY_TYPE.getEntryList(key).orElse(null);
                    if (list != null) {
                        java.util.ArrayList<net.minecraft.registry.entry.RegistryEntry<EntityType<?>>> entries = new java.util.ArrayList<>();
                        for (var it = list.iterator(); it.hasNext(); ) entries.add(it.next());
                        if (!entries.isEmpty()) {
                            var chosen = entries.get(rnd.nextInt(entries.size()));
                            return chosen.value();
                        }
                    }
                }
            } catch (Throwable ignored) { }
            return null;
        } else {
            return resolveEntityType(Identifier.tryParse(idOrTag));
        }
    }

    private void playConfiguredSound(ServerWorld world, BlockPos pos, EventKind kind) {
        var list = config.eventSounds(kind);
        if (list == null || list.isEmpty()) {
            // fallback legacy
            switch (kind) {
                case AMBUSH -> world.playSound(null, pos, SoundEvents.ENTITY_PILLAGER_AMBIENT, SoundCategory.HOSTILE, 1f, 1f);
                case MERCHANT -> world.playSound(null, pos, SoundEvents.ENTITY_VILLAGER_YES, SoundCategory.NEUTRAL, 0.8f, 1.1f);
                case PATROL -> world.playSound(null, pos, SoundEvents.ENTITY_IRON_GOLEM_REPAIR, SoundCategory.NEUTRAL, 0.8f, 1.0f);
                case WILDLIFE -> world.playSound(null, pos, SoundEvents.ENTITY_WOLF_HOWL, SoundCategory.NEUTRAL, 0.6f, 1.0f);
                default -> {}
            }
            return;
        }
        Random rnd = world.getRandom();
        String id = list.get(rnd.nextInt(list.size()));
        try {
            var soundId = Identifier.tryParse(id);
            if (soundId != null) {
                var sound = Registries.SOUND_EVENT.getOrEmpty(soundId).orElse(null);
                if (sound != null) {
                    world.playSound(null, pos, sound, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                }
            }
        } catch (Throwable ignored) {}
    }

    private static BlockPos findGround(ServerWorld world, BlockPos near) {
        int x = near.getX();
        int z = near.getZ();
        int y = net.oxcodsnet.roadarchitect.util.CacheManager.getHeight(world, x, z);
        return new BlockPos(x, y, z);
    }
}
