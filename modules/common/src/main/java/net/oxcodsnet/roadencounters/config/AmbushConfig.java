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
            // --- Ambushes: 60% total weight ---
            SpawnEntry.defaultAmbush(),
            SpawnEntry.defaultZombieAmbush(),
            SpawnEntry.defaultSkeletonAmbush(),
            SpawnEntry.defaultBanditAmbush(),
            SpawnEntry.ironcladZombieAmbush(),
            SpawnEntry.pillagerCaptainAmbush(),
            SpawnEntry.witchEscortAmbush(),
            SpawnEntry.strayAmbush(),
            SpawnEntry.hostileWolvesAmbush(),
            SpawnEntry.potionInfusedZombies(),
            SpawnEntry.wellEquippedSkeletons(),
            SpawnEntry.minerZombieAmbush(),
            SpawnEntry.farmerZombieAmbush(),
            SpawnEntry.caveSpiderAmbush(),
            SpawnEntry.drownedAmbush(),
            SpawnEntry.huskAmbush(),
            SpawnEntry.illusionerAmbush(),
            SpawnEntry.evokerAmbush(),
            SpawnEntry.speedyZombies(),
            SpawnEntry.tankyZombies(),
            SpawnEntry.chainmailZombies(),
            SpawnEntry.sharpnessZombies(),
            SpawnEntry.punchSkeletons(),
            SpawnEntry.flameSkeletons(),
            SpawnEntry.chainmailSkeletons(),
            SpawnEntry.meleeSkeletons(),
            SpawnEntry.poisonSkeletons(),
            SpawnEntry.slownessSkeletons(),
            SpawnEntry.weaknessSkeletons(),
            SpawnEntry.speedySpiders(),
            SpawnEntry.strengthSpiders(),
            SpawnEntry.invisibleSpiders(),
            // --- Action Events: 10% total weight ---
            SpawnEntry.golemVsPillagers(),
            SpawnEntry.zombieVillagerRescue(),
            // --- Peaceful Encounters: 15% total weight ---
            SpawnEntry.defaultMerchant(),
            SpawnEntry.defaultPatrol(),
            SpawnEntry.defaultWildlife(),
            SpawnEntry.defaultLostTraveler(),
            SpawnEntry.defaultWanderingHealer(),
            // --- Other: 5% total weight ---
            SpawnEntry.defaultGraveyard(),
            // --- Nothing: 10% total weight ---
            SpawnEntry.defaultNone()
    ));

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

        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> biomeWhitelist = new java.util.ArrayList<>();

        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> biomeBlacklist = new java.util.ArrayList<>();

        public static SpawnEntry defaultAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:pillager", 2, 4)));
            return e;
        }

        public static SpawnEntry defaultZombieAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 4, 6)));
            return e;
        }

        public static SpawnEntry defaultSkeletonAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 3, 5, java.util.List.of("{ArmorItems:[{},{},{},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry defaultBanditAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 3;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:zombie", 2, 3),
                    Group.of("minecraft:skeleton", 2, 3)
            ));
            return e;
        }

        public static SpawnEntry ironcladZombieAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b}],ArmorItems:[{id:\"minecraft:iron_boots\",Count:1b},{id:\"minecraft:iron_leggings\",Count:1b},{id:\"minecraft:iron_chestplate\",Count:1b},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry pillagerCaptainAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:pillager", 1, 1, java.util.List.of("{HandItems:[{id:\"minecraft:crossbow\",Count:1b},{id:\"minecraft:ominous_banner\",Count:1b}]}")),
                    Group.of("minecraft:pillager", 2, 3)
            ));
            return e;
        }

        public static SpawnEntry witchEscortAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:witch", 1, 1),
                    Group.of("minecraft:zombie", 2, 3)
            ));
            return e;
        }

        public static SpawnEntry strayAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:stray", 3, 4)));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:snowy_plains", "minecraft:ice_spikes", "minecraft:snowy_taiga", "minecraft:snowy_beach", "minecraft:grove", "minecraft:snowy_slopes", "minecraft:frozen_peaks", "minecraft:jagged_peaks"));
            return e;
        }

        public static SpawnEntry hostileWolvesAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:wolf", 3, 5, java.util.List.of("{Attributes:[{Name:\"generic.attack_damage\",Base:4.0d}]}"))));
            return e;
        }

        public static SpawnEntry potionInfusedZombies() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{ActiveEffects:[{Id:1b,Amplifier:0b,Duration:600},{Id:8b,Amplifier:0b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry wellEquippedSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:power\",lvl:1s}]}}],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry minerZombieAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{HandItems:[{id:\"minecraft:iron_pickaxe\",Count:1b}],ArmorItems:[{},{},{},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry farmerZombieAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{HandItems:[{id:\"minecraft:iron_hoe\",Count:1b}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b},{id:\"minecraft:leather_leggings\",Count:1b},{id:\"minecraft:leather_chestplate\",Count:1b},{id:\"minecraft:leather_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry caveSpiderAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:cave_spider", 3, 5)));
            return e;
        }

        public static SpawnEntry drownedAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:drowned", 2, 4, java.util.List.of("{HandItems:[{id:\"minecraft:trident\",Count:1b}]}"))));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:river", "minecraft:frozen_river", "minecraft:ocean", "minecraft:deep_ocean", "minecraft:cold_ocean", "minecraft:deep_cold_ocean", "minecraft:lukewarm_ocean", "minecraft:deep_lukewarm_ocean", "minecraft:warm_ocean", "minecraft:deep_warm_ocean", "minecraft:frozen_ocean", "minecraft:deep_frozen_ocean"));
            return e;
        }

        public static SpawnEntry huskAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:husk", 3, 4)));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:desert"));
            return e;
        }

        public static SpawnEntry illusionerAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:illusioner", 1, 1),
                    Group.of("minecraft:pillager", 2, 3)
            ));
            return e;
        }

        public static SpawnEntry evokerAmbush() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:evoker", 1, 1),
                    Group.of("minecraft:vindicator", 1, 2)
            ));
            return e;
        }

        public static SpawnEntry speedyZombies() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{ActiveEffects:[{Id:1b,Amplifier:1b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry tankyZombies() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{ActiveEffects:[{Id:11b,Amplifier:0b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry chainmailZombies() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry sharpnessZombies() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:1s}]}}]}"))));
            return e;
        }

        public static SpawnEntry punchSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:punch\",lvl:2s}]}}]}"))));
            return e;
        }

        public static SpawnEntry flameSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:flame\",lvl:1s}]}}]}"))));
            return e;
        }

        public static SpawnEntry chainmailSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry meleeSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b}]}"))));
            return e;
        }

        public static SpawnEntry poisonSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:poison\"}}]}"))));
            return e;
        }

        public static SpawnEntry slownessSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:slowness\"}}]}"))));
            return e;
        }

        public static SpawnEntry weaknessSkeletons() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:weakness\"}}]}"))));
            return e;
        }

        public static SpawnEntry speedySpiders() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 3, 4, java.util.List.of("{ActiveEffects:[{Id:1b,Amplifier:1b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry strengthSpiders() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 2, 3, java.util.List.of("{ActiveEffects:[{Id:5b,Amplifier:0b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry invisibleSpiders() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 2, 3, java.util.List.of("{ActiveEffects:[{Id:14b,Amplifier:0b,Duration:600}]}"))));
            return e;
        }

        public static SpawnEntry golemVsPillagers() {
            var e = new SpawnEntry();
            e.eventType = EventKind.PATROL;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:iron_golem", 1, 1, java.util.List.of("{Health:25f}")),
                    Group.of("minecraft:vindicator", 2, 2)
            ));
            return e;
        }

        public static SpawnEntry zombieVillagerRescue() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:zombie_villager", 1, 1),
                    Group.of("minecraft:zombie", 3, 4)
            ));
            return e;
        }

        public static SpawnEntry defaultMerchant() {
            var e = new SpawnEntry();
            e.eventType = EventKind.MERCHANT;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:wandering_trader", 1, 1),
                    Group.of("minecraft:trader_llama", 2, 2)
            ));
            return e;
        }

        public static SpawnEntry defaultPatrol() {
            var e = new SpawnEntry();
            e.eventType = EventKind.PATROL;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:iron_golem", 1, 1),
                    Group.of("minecraft:villager", 2, 3)
            ));
            return e;
        }

        public static SpawnEntry defaultWildlife() {
            var e = new SpawnEntry();
            e.eventType = EventKind.WILDLIFE;
            e.weight = 3;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:wolf", 3, 5)));
            return e;
        }

        public static SpawnEntry defaultLostTraveler() {
            var e = new SpawnEntry();
            e.eventType = EventKind.PATROL; // Using PATROL as it's a non-hostile event
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:villager", 1, 1)));
            return e;
        }

        public static SpawnEntry defaultWanderingHealer() {
            var e = new SpawnEntry();
            e.eventType = EventKind.MERCHANT; // Using MERCHANT as it's a non-hostile event
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:villager", 1, 1, java.util.List.of("{VillagerData:{profession:\"minecraft:cleric\"}}"))));
            return e;
        }

        public static SpawnEntry defaultGraveyard() {
            var e = new SpawnEntry();
            e.eventType = EventKind.AMBUSH;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4)));
            return e;
        }

        public static SpawnEntry defaultNone() {
            var e = new SpawnEntry();
            e.eventType = EventKind.NONE;
            e.weight = 10;
            e.groups = new java.util.ArrayList<>();
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

        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> nbt = new java.util.ArrayList<>(); // JSON string for NBT data

        public static Group of(String idOrTag, int min, int max) {
            return of(idOrTag, min, max, new java.util.ArrayList<>());
        }

        public static Group of(String idOrTag, int min, int max, String nbt) {
            var g = new Group();
            g.idOrTag = idOrTag;
            g.countMin = min;
            g.countMax = max;
            g.nbt = new java.util.ArrayList<>();
            if (nbt != null && !nbt.isEmpty()) {
                g.nbt.add(nbt);
            }
            return g;
        }

        public static Group of(String idOrTag, int min, int max, java.util.List<String> nbt) {
            var g = new Group();
            g.idOrTag = idOrTag;
            g.countMin = min;
            g.countMax = max;
            g.nbt = new java.util.ArrayList<>(nbt);
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
