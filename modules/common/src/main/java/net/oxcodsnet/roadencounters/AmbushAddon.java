package net.oxcodsnet.roadencounters;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PatrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.entity.passive.WolfEntity;
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
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
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
        EncounterType type = pickEncounter(config.eventWeights(), rnd);
        switch (type) {
            case NONE -> sendActionbar(player, "message.roadarchitect_roadencounters.none");
            case AMBUSH -> {
                if (world.getDifficulty() != Difficulty.PEACEFUL) {
                    handleAmbush(world, pos);
                    sendActionbar(player, "message.roadarchitect_roadencounters.ambush");
                    world.playSound(null, pos, SoundEvents.ENTITY_PILLAGER_AMBIENT, SoundCategory.HOSTILE, 1f, 1f);
                }
            }
            case MERCHANT -> {
                spawnMerchant(world, pos, rnd);
                sendActionbar(player, "message.roadarchitect_roadencounters.merchant");
                world.playSound(null, pos, SoundEvents.ENTITY_VILLAGER_YES, SoundCategory.NEUTRAL, 0.8f, 1.1f);
            }
            case PATROL -> {
                spawnPatrol(world, pos, rnd);
                sendActionbar(player, "message.roadarchitect_roadencounters.patrol");
                world.playSound(null, pos, SoundEvents.ENTITY_IRON_GOLEM_REPAIR, SoundCategory.NEUTRAL, 0.8f, 1.0f);
            }
            case WILDLIFE -> {
                spawnWildlife(world, pos, rnd);
                sendActionbar(player, "message.roadarchitect_roadencounters.wildlife");
            }
            case TREASURE -> {
                placeTreasure(world, pos, rnd);
                sendActionbar(player, "message.roadarchitect_roadencounters.treasure");
                world.playSound(null, pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.9f, 1.0f);
            }
        }
    }

    private void spawnMerchant(ServerWorld world, BlockPos pos, Random rnd) {
        BlockPos base = findGround(world, pos);
        WanderingTraderEntity trader = EntityType.WANDERING_TRADER.create(world);
        if (trader != null) {
            trader.initialize(world, world.getLocalDifficulty(base), SpawnReason.EVENT, null);
            trader.refreshPositionAndAngles(base, rnd.nextFloat() * 360f, 0);
            world.spawnEntity(trader);
        }
        int llamas = 1 + rnd.nextInt(2);
        for (int i = 0; i < llamas; i++) {
            int r = Math.max(2, config.spawnOffset());
            BlockPos p = findGround(world, base.add(rnd.nextInt(r * 2 + 1) - r, 0, rnd.nextInt(r * 2 + 1) - r));
            EntityType<?> et = Registries.ENTITY_TYPE.getOrEmpty(Identifier.of("minecraft", "trader_llama")).orElse(null);
            Entity e = et == null ? null : et.create(world);
            if (e instanceof MobEntity me) {
                me.initialize(world, world.getLocalDifficulty(p), SpawnReason.EVENT, null);
                me.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                world.spawnEntity(me);
            }
        }
    }

    private void spawnPatrol(ServerWorld world, BlockPos pos, Random rnd) {
        BlockPos base = findGround(world, pos);
        Entity golem = EntityType.IRON_GOLEM.create(world);
        if (golem instanceof MobEntity me) {
            me.initialize(world, world.getLocalDifficulty(base), SpawnReason.EVENT, null);
            me.refreshPositionAndAngles(base, rnd.nextFloat() * 360f, 0);
            world.spawnEntity(me);
        }
        int villagers = 1 + rnd.nextInt(2);
        for (int i = 0; i < villagers; i++) {
            int r = Math.max(2, config.spawnOffset());
            BlockPos p = findGround(world, base.add(rnd.nextInt(r * 2 + 1) - r, 0, rnd.nextInt(r * 2 + 1) - r));
            VillagerEntity v = EntityType.VILLAGER.create(world);
            if (v != null) {
                v.initialize(world, world.getLocalDifficulty(p), SpawnReason.EVENT, null);
                v.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                world.spawnEntity(v);
            }
        }
    }

    private void spawnWildlife(ServerWorld world, BlockPos pos, Random rnd) {
        BlockPos base = findGround(world, pos);
        boolean wolves = rnd.nextInt(100) < 45;
        if (wolves) {
            int pack = 2 + rnd.nextInt(3);
            for (int i = 0; i < pack; i++) {
                int r = Math.max(2, config.spawnOffset());
                BlockPos p = findGround(world, base.add(rnd.nextInt(r * 2 + 1) - r, 0, rnd.nextInt(r * 2 + 1) - r));
                WolfEntity w = EntityType.WOLF.create(world);
                if (w != null) {
                    w.initialize(world, world.getLocalDifficulty(p), SpawnReason.EVENT, null);
                    w.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                    world.spawnEntity(w);
                }
            }
            world.playSound(null, base, SoundEvents.ENTITY_WOLF_HOWL, SoundCategory.NEUTRAL, 0.6f, 1.0f);
        } else {
            int herd = 2 + rnd.nextInt(3);
            for (int i = 0; i < herd; i++) {
                int r = Math.max(2, config.spawnOffset());
                BlockPos p = findGround(world, base.add(rnd.nextInt(r * 2 + 1) - r, 0, rnd.nextInt(r * 2 + 1) - r));
                HorseEntity h = EntityType.HORSE.create(world);
                if (h != null) {
                    h.initialize(world, world.getLocalDifficulty(p), SpawnReason.EVENT, null);
                    h.refreshPositionAndAngles(p, rnd.nextFloat() * 360f, 0);
                    world.spawnEntity(h);
                }
            }
            world.playSound(null, base, SoundEvents.ENTITY_HORSE_AMBIENT, SoundCategory.NEUTRAL, 0.6f, 1.0f);
        }
    }

    private void placeTreasure(ServerWorld world, BlockPos pos, Random rnd) {
        BlockPos ground = findGround(world, pos);
        BlockPos chestPos = ground.getY() >= world.getBottomY() ? ground : pos;
        if (!world.getBlockState(ground).isAir()) {
            BlockPos above = ground.up();
            if (world.getBlockState(above).isAir()) chestPos = above;
        }
        if (!world.getBlockState(chestPos).isAir()) return;
        world.setBlockState(chestPos, Blocks.CHEST.getDefaultState());
        BlockEntity be = world.getBlockEntity(chestPos);
        if (be instanceof ChestBlockEntity chest) {
            addRandomLoot(chest, rnd, 3 + rnd.nextInt(3));
            chest.markDirty();
        }
    }

    private static void addRandomLoot(ChestBlockEntity chest, Random rnd, int items) {
        ItemStack[] pool = new ItemStack[] {
                new ItemStack(Items.BREAD, 2 + rnd.nextInt(3)),
                new ItemStack(Items.TORCH, 6 + rnd.nextInt(8)),
                new ItemStack(Items.ARROW, 6 + rnd.nextInt(12)),
                new ItemStack(Items.IRON_INGOT, 1 + rnd.nextInt(3)),
                new ItemStack(Items.GOLD_NUGGET, 4 + rnd.nextInt(8)),
                new ItemStack(Items.APPLE, 1 + rnd.nextInt(3)),
                new ItemStack(Items.LEATHER, 2 + rnd.nextInt(4))
        };
        int size = chest.size();
        for (int i = 0; i < items; i++) {
            ItemStack pick = pool[rnd.nextInt(pool.length)].copy();
            int slot = rnd.nextInt(size);
            chest.setStack(slot, pick);
        }
    }

    private static void sendActionbar(ServerPlayerEntity player, String key) {
        player.sendMessage(Text.translatable(key), true);
    }

    private enum EncounterType { NONE, AMBUSH, MERCHANT, PATROL, WILDLIFE, TREASURE }

    private static EncounterType pickEncounter(REConfig.EventWeights w, Random rnd) {
        if (w == null) return EncounterType.AMBUSH;
        int[] weights = new int[]{ w.none(), w.ambush(), w.merchant(), w.patrol(), w.wildlife(), w.treasure() };
        EncounterType[] types = new EncounterType[]{ EncounterType.NONE, EncounterType.AMBUSH, EncounterType.MERCHANT, EncounterType.PATROL, EncounterType.WILDLIFE, EncounterType.TREASURE };
        int total = 0;
        for (int x : weights) if (x > 0) total += x;
        if (total <= 0) return EncounterType.AMBUSH;
        int r = rnd.nextInt(total);
        int acc = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= 0) continue;
            acc += weights[i];
            if (r < acc) return types[i];
        }
        return EncounterType.AMBUSH;
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
