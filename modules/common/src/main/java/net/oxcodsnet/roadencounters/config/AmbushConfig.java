package net.oxcodsnet.roadencounters.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.oxcodsnet.roadencounters.config.EventKind;

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

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
    public EventKind testEnum = EventKind.AMBUSH;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("types")
    @ConfigEntry.Gui.CollapsibleObject
    public Types types = new Types();

    public static class SpawnEntry {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
        public EventKind eventType = EventKind.AMBUSH; // selectable enum

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int weight = 100; // overall weight for this entry

        @ConfigEntry.Gui.Tooltip
        public java.util.List<Group> groups = new java.util.ArrayList<>(java.util.List.of(
                Group.of("minecraft:pillager", 4, 5)
        ));

        public static SpawnEntry defaultAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
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

    public static class Types {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.CollapsibleObject
        public TypeEntry ambush = TypeEntry.of(java.util.List.of("minecraft:entity.pillager.ambient"));
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.CollapsibleObject
        public TypeEntry merchant = TypeEntry.of(java.util.List.of("minecraft:entity.villager.yes"));
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.CollapsibleObject
        public TypeEntry patrol = TypeEntry.of(java.util.List.of("minecraft:entity.iron_golem.repair"));
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.CollapsibleObject
        public TypeEntry wildlife = TypeEntry.of(java.util.List.of("minecraft:entity.wolf.howl"));
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.CollapsibleObject
        public TypeEntry none = TypeEntry.of(java.util.List.of());
    }

    public static class TypeEntry {
        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> sounds = new java.util.ArrayList<>();

        public static TypeEntry of(java.util.List<String> ids) {
            var t = new TypeEntry();
            t.sounds = new java.util.ArrayList<>(ids);
            return t;
        }
    }
}
