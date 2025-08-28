package net.oxcodsnet.roadencounters;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.PatrolEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddon;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddons;
import net.oxcodsnet.roadarchitect.api.addon.TriggerHandler;
import net.oxcodsnet.roadarchitect.api.addon.TriggerType;
import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Ambush encounter addon for RoadArchitect. Registers a trigger and places markers along finalized paths.
 */
public final class AmbushAddon implements RoadAddon {
    public static final String MOD_ID = "roadencounters";
    public static final Identifier ADDON_ID = Identifier.of(MOD_ID, "ambush_addon");
    public static final Identifier AMBUSH_TRIGGER = Identifier.of(MOD_ID, "ambush");
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + "/AmbushAddon");

    @Override
    public Identifier id() {
        return ADDON_ID;
    }

    @Override
    public void onRegister() {
        RoadAddons.registerTriggerType(new TriggerType(AMBUSH_TRIGGER, 75, ambushHandler()));
    }

    @Override
    public void onPathReady(ServerWorld world, String pathKey, List<BlockPos> refinedPath) {
        if (refinedPath.size() < 16) return;
        int maxMarkers = 3;
        int stride = 160;
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
                RoadAddons.placeMarker(world, p, AMBUSH_TRIGGER, new NbtCompound());
                placed++;
                if (placed >= maxMarkers) break;
                acc = 0;
            }
        }

        if (placed > 0) {
            LOGGER.info("Ambush markers placed: {} on {}", placed, pathKey);
        }
    }

    private static TriggerHandler ambushHandler() {
        return (ServerWorld world, BlockPos pos, ServerPlayerEntity player, NbtCompound data) -> {
            if (world.getDifficulty() == Difficulty.PEACEFUL) return;
            Random rnd = world.getRandom();
            int count = 4 + rnd.nextInt(2); // 4-5
            for (int i = 0; i < count; i++) {
                int ox = rnd.nextInt(13) - 6; // [-6,6]
                int oz = rnd.nextInt(13) - 6; // [-6,6]
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
        };
    }

    private static BlockPos findGround(ServerWorld world, BlockPos near) {
        int x = near.getX();
        int z = near.getZ();
        int y = net.oxcodsnet.roadarchitect.util.CacheManager.getHeight(world, x, z);
        return new BlockPos(x, y, z);
    }
}
