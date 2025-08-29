package net.oxcodsnet.roadencounters.storage;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.oxcodsnet.roadarchitect.api.storage.PersistentStore;
import org.slf4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Addon-local trigger storage backed by RA PersistentStore (per-world, per-addon).
 */
public final class TriggerStorage {
    private static final String LIST = "markers";
    private static final String ID = "id";
    private static final String POS = "pos"; // long
    private static final String TYPE = "type"; // string
    private static final String RADIUS = "radius"; // int
    private static final String DATA = "data"; // compound
    private static final String NEXT_READY = "next_ready"; // long (world ticks)

    private final Identifier storeKey;
    private final Function<ServerWorld, PersistentStore> store;
    private final Logger logger;

    private final Map<ServerWorld, State> states = new WeakHashMap<>();

    public record Marker(UUID id, BlockPos pos, Identifier type, int radius, NbtCompound data, long nextReadyTick) { }

    private static final class State {
        final Map<UUID, Marker> byId = new ConcurrentHashMap<>();
        final Map<ChunkPos, Set<UUID>> byChunk = new ConcurrentHashMap<>();
    }

    public TriggerStorage(Identifier storeKey, Function<ServerWorld, PersistentStore> store, Logger logger) {
        this.storeKey = storeKey;
        this.store = store;
        this.logger = logger;
    }

    public static TriggerStorage create(Function<ServerWorld, PersistentStore> store, Logger logger, Identifier addonId) {
        return new TriggerStorage(Identifier.of(addonId.getNamespace(), addonId.getPath() + "_triggers"), store, logger);
    }

    private State state(ServerWorld world) {
        return states.computeIfAbsent(world, this::load);
    }

    private State load(ServerWorld world) {
        State s = new State();
        Optional<NbtCompound> opt = store.apply(world).get(storeKey);
        if (opt.isEmpty()) return s;
        NbtCompound tag = opt.get();
        NbtList list = tag.getList(LIST, NbtElement.COMPOUND_TYPE);
        for (int i = 0; i < list.size(); i++) {
            NbtCompound e = list.getCompound(i);
            UUID id = e.getUuid(ID);
            BlockPos pos = BlockPos.fromLong(e.getLong(POS));
            Identifier type = Identifier.tryParse(e.getString(TYPE));
            int radius = e.getInt(RADIUS);
            NbtCompound data = e.getCompound(DATA);
            long nextReady = e.contains(NEXT_READY) ? e.getLong(NEXT_READY) : 0L;
            if (type == null) continue;
            index(s, new Marker(id, pos, type, radius, data.copy(), nextReady));
        }
        return s;
    }

    private void save(ServerWorld world, State s) {
        NbtList list = new NbtList();
        for (Marker m : s.byId.values()) {
            NbtCompound e = new NbtCompound();
            e.putUuid(ID, m.id());
            e.putLong(POS, m.pos().asLong());
            e.putString(TYPE, m.type().toString());
            e.putInt(RADIUS, m.radius());
            e.put(DATA, m.data().copy());
            if (m.nextReadyTick() > 0L) {
                e.putLong(NEXT_READY, m.nextReadyTick());
            }
            list.add(e);
        }
        NbtCompound root = new NbtCompound();
        root.put(LIST, list);
        store.apply(world).put(storeKey, root);
    }

    private static void index(State s, Marker m) {
        s.byId.put(m.id(), m);
        s.byChunk.computeIfAbsent(new ChunkPos(m.pos()), c -> ConcurrentHashMap.newKeySet()).add(m.id());
    }

    public void addMarker(ServerWorld world, BlockPos pos, Identifier type, int radius, NbtCompound data) {
        State s = state(world);
        UUID id = UUID.randomUUID();
        index(s, new Marker(id, pos.toImmutable(), type, radius, data == null ? new NbtCompound() : data.copy(), 0L));
        save(world, s);
        logger.debug("Added marker {} at {} (r={})", type, pos, radius);
    }

    public List<Marker> findMarkersNear(ServerWorld world, BlockPos pos, int maxSearchRadiusBlocks) {
        State s = state(world);
        if (s.byId.isEmpty()) return List.of();
        int cx = pos.getX() >> 4;
        int cz = pos.getZ() >> 4;
        int rChunks = Math.max(1, Math.min(8, (maxSearchRadiusBlocks + 15) >> 4));
        long now = world.getTime();
        List<Marker> out = new ArrayList<>();
        for (int dx = -rChunks; dx <= rChunks; dx++) {
            for (int dz = -rChunks; dz <= rChunks; dz++) {
                Set<UUID> ids = s.byChunk.get(new ChunkPos(cx + dx, cz + dz));
                if (ids == null || ids.isEmpty()) continue;
                for (UUID id : ids) {
                    Marker m = s.byId.get(id);
                    if (m == null) continue;
                    if (m.nextReadyTick() > now) continue; // still on cooldown
                    int rx = m.pos().getX() - pos.getX();
                    int rz = m.pos().getZ() - pos.getZ();
                    if ((long) rx * rx + (long) rz * rz <= (long) m.radius() * m.radius()) {
                        out.add(m);
                    }
                }
            }
        }
        return out;
    }

    public void markTriggered(ServerWorld world, Collection<UUID> ids, long cooldownTicks) {
        if (ids.isEmpty()) return;
        State s = state(world);
        long until = world.getTime() + Math.max(0L, cooldownTicks);
        for (UUID id : ids) {
            Marker m = s.byId.get(id);
            if (m == null) continue;
            // reinsert updated record
            s.byId.put(id, new Marker(m.id(), m.pos(), m.type(), m.radius(), m.data(), until));
        }
        save(world, s);
    }
}
