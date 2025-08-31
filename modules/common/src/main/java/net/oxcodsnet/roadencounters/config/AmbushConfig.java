package net.oxcodsnet.roadencounters.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "roadarchitect_roadencounters")
public class AmbushConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 32)
    public int maxMarkers = 3;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 16, max = 4096)
    public int strideBlocks = 160;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 15, max = 512)
    public int triggerRadius = 75;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 5, max = 86400)
    public int cooldownSeconds = 300;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 32)
    public int spawnOffset = 6;

    @ConfigEntry.Gui.Tooltip
    public java.util.List<SpawnEntry> spawns = new java.util.ArrayList<>(java.util.List.of(
            SpawnEntry.defaultPillager()
    ));

    public static class SpawnEntry {
        @ConfigEntry.Gui.Tooltip
        public String entityId = "minecraft:pillager";

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int weight = 100;

        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        public int countMin = 4;

        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        public int countMax = 5;

        public static SpawnEntry defaultPillager() {
            var e = new SpawnEntry();
            e.entityId = "minecraft:pillager";
            e.weight = 100;
            e.countMin = 4;
            e.countMax = 5;
            return e;
        }
    }

    // Data class only; platform bridges register and expose via REConfigHolder
}
