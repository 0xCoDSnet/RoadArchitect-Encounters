package net.oxcodsnet.roadencounters;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PatrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
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
import net.oxcodsnet.roadarchitect.api.addon.AddonContext;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddon;
import net.oxcodsnet.roadencounters.storage.TriggerStorage;
import net.oxcodsnet.roadencounters.config.REConfig;
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
                handleAmbush(world, m.pos());
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

    private void handleAmbush(ServerWorld world, BlockPos pos) {
        if (world.getDifficulty() == Difficulty.PEACEFUL) return;
        Random rnd = world.getRandom();
        // decide what to spawn via weighted list; ensure non-null fallback
        REConfig.SpawnSpec picked = pickSpawn(config, rnd);
        int count = picked.countMin() + rnd.nextInt(Math.max(1, (picked.countMax() - picked.countMin() + 1)));
        Identifier chosenId = Identifier.tryParse(picked.entityId());

        for (int i = 0; i < count; i++) {
            int r = config.spawnOffset();
            int ox = rnd.nextInt(r * 2 + 1) - r;
            int oz = rnd.nextInt(r * 2 + 1) - r;
            BlockPos spawn = findGround(world, pos.add(ox, 0, oz));
            EntityType<?> type = resolveEntityType(chosenId);
            if (type == null) {
                // fallback to pillager if invalid id
                type = EntityType.PILLAGER;
            }
            Entity e = type.create(world);
            if (e == null) continue;
            if (e instanceof MobEntity me) {
                me.initialize(world, world.getLocalDifficulty(spawn), SpawnReason.EVENT, null);
                me.refreshPositionAndAngles(spawn, rnd.nextFloat() * 360f, 0);
                world.spawnEntity(me);
                if (i == 0 && me instanceof PatrolEntity pe) {
                    pe.setPatrolLeader(true);
                }
            } else {
                e.refreshPositionAndAngles(spawn, rnd.nextFloat() * 360f, 0);
                world.spawnEntity(e);
            }
        }
    }

    private static EntityType<?> resolveEntityType(Identifier id) {
        if (id == null) return null;
        return Registries.ENTITY_TYPE.getOrEmpty(id).orElse(null);
    }

    private static REConfig.SpawnSpec pickSpawn(REConfig cfg, Random rnd) {
        var list = cfg.spawnSpecs();
        if (list == null || list.isEmpty()) return new REConfig.SpawnSpec("minecraft:pillager", 100, 4, 5);
        int total = 0;
        for (var s : list) {
            if (s.weight() > 0) total += s.weight();
        }
        if (total <= 0) return list.get(0);
        int r = rnd.nextInt(total);
        int acc = 0;
        for (var s : list) {
            if (s.weight() <= 0) continue;
            acc += s.weight();
            if (r < acc) return s;
        }
        return list.get(0);
    }

    private static BlockPos findGround(ServerWorld world, BlockPos near) {
        int x = near.getX();
        int z = near.getZ();
        int y = net.oxcodsnet.roadarchitect.util.CacheManager.getHeight(world, x, z);
        return new BlockPos(x, y, z);
    }
}
