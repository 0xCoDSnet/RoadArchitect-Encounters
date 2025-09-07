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
    java.util.List<SpawnSpec> spawnSpecs();
    EventWeights eventWeights();

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
}
