package net.oxcodsnet.roadencounters;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PatrolEntity;
import net.minecraft.entity.mob.PillagerEntity;
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
    public static final String MOD_ID = "roadencounters";
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
        int count = config.mobsMin() + rnd.nextInt(Math.max(1, (config.mobsMax() - config.mobsMin() + 1)));
        for (int i = 0; i < count; i++) {
            int r = config.spawnOffset();
            int ox = rnd.nextInt(r * 2 + 1) - r;
            int oz = rnd.nextInt(r * 2 + 1) - r;
            BlockPos spawn = findGround(world, pos.add(ox, 0, oz));
            PillagerEntity mob = EntityType.PILLAGER.create(world);
            if (mob == null) continue;
            mob.initialize((ServerWorldAccess) world, world.getLocalDifficulty(spawn), SpawnReason.EVENT, null);
            mob.refreshPositionAndAngles(spawn, rnd.nextFloat() * 360f, 0);
            world.spawnEntity(mob);
            if (i == 0 && mob instanceof PatrolEntity pe) {
                pe.setPatrolLeader(true);
            }
        }
    }

    private static BlockPos findGround(ServerWorld world, BlockPos near) {
        int x = near.getX();
        int z = near.getZ();
        int y = net.oxcodsnet.roadarchitect.util.CacheManager.getHeight(world, x, z);
        return new BlockPos(x, y, z);
    }
}
