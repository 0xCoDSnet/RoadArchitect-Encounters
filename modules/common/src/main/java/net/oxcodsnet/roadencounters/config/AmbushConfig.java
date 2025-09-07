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
    public boolean debugActionbar = false;

    @ConfigEntry.Gui.Tooltip
    public java.util.List<SpawnEntry> spawns = new java.util.ArrayList<>(java.util.List.of(
            SpawnEntry.defaultAmbush()
    ));

    public static class SpawnEntry {
        @ConfigEntry.Gui.Tooltip
        public String eventType = "ambush"; // ambush, merchant, patrol, wildlife, none

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int weight = 100; // overall weight for this entry

        @ConfigEntry.Gui.Tooltip
        public java.util.List<Group> groups = new java.util.ArrayList<>(java.util.List.of(
                Group.of("minecraft:pillager", 4, 5)
        ));

        public static SpawnEntry defaultAmbush() {
            var e = new SpawnEntry();
            e.eventType = "ambush";
            e.weight = 100;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:pillager", 4, 5)));
            return e;
        }
    }

    public static class Group {
        @ConfigEntry.Gui.Tooltip
        public String idOrTag = "minecraft:pillager"; // supports '#namespace:tag' or direct entity id

        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        public int countMin = 1;

        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        public int countMax = 1;

        public static Group of(String idOrTag, int min, int max) {
            var g = new Group();
            g.idOrTag = idOrTag;
            g.countMin = min;
            g.countMax = max;
            return g;
        }
    }
}
