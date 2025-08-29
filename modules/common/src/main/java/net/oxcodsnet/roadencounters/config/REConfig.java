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
    int mobsMin();
    int mobsMax();
    int spawnOffset();

    default long cooldownTicks() { return (long) cooldownSeconds() * 20L; }
}

