package net.oxcodsnet.roadencounters.config;

/**
 * Cross-platform config facade, implemented by platform bridges
 * based on Cloth Config (AutoConfig) data.
 */
public interface REConfig {
    int maxMarkers();
    int strideBlocks();
    int triggerRadius();
    int cooldownSeconds();
    int spawnOffset();
    // Legacy (no longer used by logic, kept for compatibility)
    @Deprecated
    default java.util.List<SpawnSpec> spawnSpecs() { return java.util.List.of(); }
    @Deprecated
    default EventWeights eventWeights() { return new EventWeights(0,0,0,0,0,100); }

    // New unified encounter specs: each entry selects an event kind and a list of entity/tag groups with counts,
    // and a single weight for the whole entry.
    java.util.List<EncounterSpec> encounterSpecs();
    java.util.List<String> eventSounds(EventKind kind);
    boolean debugActionbar();

    default long cooldownTicks() { return (long) cooldownSeconds() * 20L; }

    /**
     * Defines one spawn option in the weighted list.
     */
    record SpawnSpec(String entityId, int weight, int countMin, int countMax) {}

    /**
     * High-level encounter type weights to diversify events on the road.
     */
    record EventWeights(int ambush, int merchant, int patrol, int wildlife, int treasure, int none) {
        public int total() {
            long t = (long) ambush + merchant + patrol + wildlife + treasure + none;
            return (int) Math.max(0, Math.min(Integer.MAX_VALUE, t));
        }
    }

    /**
     * New unified spec driving both event type selection and spawned mobs.
     */
    record EncounterSpec(EventKind eventType, int weight, java.util.List<Group> groups) {
        public EventKind eventType() { return eventType == null ? EventKind.AMBUSH : eventType; }
    }

    /** One group within an encounter: entity id or tag, and per-group count. */
    record Group(String idOrTag, int countMin, int countMax, String nbt) {}
}
