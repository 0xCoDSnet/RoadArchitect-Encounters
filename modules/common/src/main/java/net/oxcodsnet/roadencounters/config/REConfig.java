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

    default long cooldownTicks() { return (long) cooldownSeconds() * 20L; }

    /**
     * Defines one spawn option in the weighted list.
     */
    record SpawnSpec(String entityId, int weight, int countMin, int countMax) {}
}
