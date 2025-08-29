package net.oxcodsnet.roadencounters.config;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * Singleton holder for the active platform-backed config implementation.
 */
public final class REConfigHolder {
    private static final CopyOnWriteArrayList<Consumer<REConfig>> LISTENERS = new CopyOnWriteArrayList<>();
    private static volatile REConfig INSTANCE = new Defaults();

    private REConfigHolder() {}

    public static REConfig get() { return INSTANCE; }

    public static void set(REConfig impl) {
        INSTANCE = Objects.requireNonNull(impl, "impl");
        for (var l : LISTENERS) l.accept(INSTANCE);
    }

    public static AutoCloseable listen(Consumer<REConfig> listener) {
        LISTENERS.add(Objects.requireNonNull(listener));
        listener.accept(INSTANCE);
        return () -> LISTENERS.remove(listener);
    }

    private static final class Defaults implements REConfig {
        @Override public int maxMarkers() { return 3; }
        @Override public int strideBlocks() { return 160; }
        @Override public int triggerRadius() { return 75; }
        @Override public int cooldownSeconds() { return 300; }
        @Override public int spawnOffset() { return 6; }
        @Override public java.util.List<REConfig.SpawnSpec> spawnSpecs() {
            return java.util.List.of(new REConfig.SpawnSpec("minecraft:pillager", 100, 4, 5));
        }
    }
}
