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
        @Override public boolean debugActionbar() { return false; }
        @Override public java.util.List<REConfig.EncounterSpec> encounterSpecs() {
            return java.util.List.of(
                    new REConfig.EncounterSpec(
                            EventKind.AMBUSH,
                            100,
                            java.util.List.of(new REConfig.Group("minecraft:pillager", 4, 5, ""))
                    ),
                    new REConfig.EncounterSpec(EventKind.NONE, 2, java.util.List.of())
            );
        }
        @Override public java.util.List<String> eventSounds(EventKind kind) {
            return switch (kind) {
                case AMBUSH -> java.util.List.of("minecraft:entity.pillager.ambient");
                case MERCHANT -> java.util.List.of("minecraft:entity.villager.yes");
                case PATROL -> java.util.List.of("minecraft:entity.iron_golem.repair");
                case WILDLIFE -> java.util.List.of("minecraft:entity.wolf.howl");
                case NONE -> java.util.List.of();
            };
        }
    }
}
