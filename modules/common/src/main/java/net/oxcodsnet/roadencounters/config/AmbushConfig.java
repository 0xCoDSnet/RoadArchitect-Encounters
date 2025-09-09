package net.oxcodsnet.roadencounters.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "roadarchitect_roadencounters")
public class AmbushConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean debugActionbar = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 64)
    public int maxMarkers = 3;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 16, max = 6144)
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

    @ConfigEntry.Gui.Excluded
    private static final java.util.List<String> WATER_BIOMES = java.util.List.of(
            "minecraft:river", "minecraft:frozen_river", "minecraft:ocean", "minecraft:deep_ocean",
            "minecraft:cold_ocean", "minecraft:deep_cold_ocean", "minecraft:lukewarm_ocean",
            "minecraft:deep_lukewarm_ocean", "minecraft:warm_ocean", "minecraft:deep_warm_ocean",
            "minecraft:frozen_ocean", "minecraft:deep_frozen_ocean"
    );

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("spawns")
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
        @ConfigEntry.Gui.Excluded
        public transient Preset preset = Preset.DEFAULT_AMBUSH;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
        public EventKind eventType = EventKind.AMBUSH; // selectable enum

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int weight = 4; // overall weight for this entry (align with defaultAmbush)

        @ConfigEntry.Gui.Tooltip
        public java.util.List<Group> groups = new java.util.ArrayList<>(java.util.List.of(
                Group.of("minecraft:pillager", 2, 4)
        ));

        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> biomeWhitelist = new java.util.ArrayList<>();

        @ConfigEntry.Gui.Tooltip
        public java.util.List<String> biomeBlacklist = new java.util.ArrayList<>();

        public static SpawnEntry defaultAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:pillager", 2, 4)));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultZombieAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_ZOMBIE_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 4, 6)));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultSkeletonAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_SKELETON_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 3, 5, java.util.List.of("{ArmorItems:[{},{},{},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultBanditAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_BANDIT_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 3;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:zombie", 2, 3),
                    Group.of("minecraft:skeleton", 2, 3)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry ironcladZombieAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.IRONCLAD_ZOMBIE_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b}],ArmorItems:[{id:\"minecraft:iron_boots\",Count:1b},{id:\"minecraft:iron_leggings\",Count:1b},{id:\"minecraft:iron_chestplate\",Count:1b},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry pillagerCaptainAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.PILLAGER_CAPTAIN_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:pillager", 1, 1, java.util.List.of("{HandItems:[{id:\"minecraft:crossbow\",Count:1b},{id:\"minecraft:ominous_banner\",Count:1b}]}")),
                    Group.of("minecraft:pillager", 2, 3)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry witchEscortAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.WITCH_ESCORT_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:witch", 1, 1),
                    Group.of("minecraft:zombie", 2, 3)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry strayAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.STRAY_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:stray", 3, 4)));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:snowy_plains", "minecraft:ice_spikes", "minecraft:snowy_taiga", "minecraft:snowy_beach", "minecraft:grove", "minecraft:snowy_slopes", "minecraft:frozen_peaks", "minecraft:jagged_peaks"));
            return e;
        }

        public static SpawnEntry hostileWolvesAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.HOSTILE_WOLVES_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:wolf", 3, 5, java.util.List.of("{Attributes:[{Name:\"generic.attack_damage\",Base:4.0d}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry potionInfusedZombies() {
            var e = new SpawnEntry();
            e.preset = Preset.POTION_INFUSED_ZOMBIES;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:speed\",Amplifier:0b,Duration:600},{Id:\"minecraft:jump_boost\",Amplifier:0b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry wellEquippedSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.WELL_EQUIPPED_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:power\",lvl:1s}]}}],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry minerZombieAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.MINER_ZOMBIE_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{HandItems:[{id:\"minecraft:iron_pickaxe\",Count:1b}],ArmorItems:[{},{},{},{id:\"minecraft:iron_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry farmerZombieAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.FARMER_ZOMBIE_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{HandItems:[{id:\"minecraft:iron_hoe\",Count:1b}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b},{id:\"minecraft:leather_leggings\",Count:1b},{id:\"minecraft:leather_chestplate\",Count:1b},{id:\"minecraft:leather_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry caveSpiderAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.CAVE_SPIDER_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:cave_spider", 3, 5)));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry drownedAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.DROWNED_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:drowned", 2, 4, java.util.List.of("{HandItems:[{id:\"minecraft:trident\",Count:1b}]}"))));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:river", "minecraft:frozen_river", "minecraft:ocean", "minecraft:deep_ocean", "minecraft:cold_ocean", "minecraft:deep_cold_ocean", "minecraft:lukewarm_ocean", "minecraft:deep_lukewarm_ocean", "minecraft:warm_ocean", "minecraft:deep_warm_ocean", "minecraft:frozen_ocean", "minecraft:deep_frozen_ocean"));
            return e;
        }

        public static SpawnEntry huskAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.HUSK_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:husk", 3, 4)));
            e.biomeWhitelist = new java.util.ArrayList<>(java.util.List.of("minecraft:desert"));
            return e;
        }

        public static SpawnEntry illusionerAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.ILLUSIONER_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:illusioner", 1, 1),
                    Group.of("minecraft:pillager", 2, 3)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry evokerAmbush() {
            var e = new SpawnEntry();
            e.preset = Preset.EVOKER_AMBUSH;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:evoker", 1, 1),
                    Group.of("minecraft:vindicator", 1, 2)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry speedyZombies() {
            var e = new SpawnEntry();
            e.preset = Preset.SPEEDY_ZOMBIES;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 3, 4, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:speed\",Amplifier:1b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry tankyZombies() {
            var e = new SpawnEntry();
            e.preset = Preset.TANKY_ZOMBIES;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:resistance\",Amplifier:0b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry chainmailZombies() {
            var e = new SpawnEntry();
            e.preset = Preset.CHAINMAIL_ZOMBIES;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry sharpnessZombies() {
            var e = new SpawnEntry();
            e.preset = Preset.SHARPNESS_ZOMBIES;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:zombie", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:1s}]}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry punchSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.PUNCH_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:punch\",lvl:2s}]}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry flameSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.FLAME_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:flame\",lvl:1s}]}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry chainmailSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.CHAINMAIL_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry meleeSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.MELEE_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:iron_sword\",Count:1b}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry poisonSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.POISON_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:poison\"}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry slownessSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.SLOWNESS_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:slowness\"}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry weaknessSkeletons() {
            var e = new SpawnEntry();
            e.preset = Preset.WEAKNESS_SKELETONS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:skeleton", 2, 3, java.util.List.of("{HandItems:[{id:\"minecraft:bow\",Count:1b},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{Potion:\"minecraft:weakness\"}}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry speedySpiders() {
            var e = new SpawnEntry();
            e.preset = Preset.SPEEDY_SPIDERS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 3, 4, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:speed\",Amplifier:1b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry strengthSpiders() {
            var e = new SpawnEntry();
            e.preset = Preset.STRENGTH_SPIDERS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 2, 3, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:strength\",Amplifier:0b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry invisibleSpiders() {
            var e = new SpawnEntry();
            e.preset = Preset.INVISIBLE_SPIDERS;
            e.eventType = EventKind.AMBUSH;
            e.weight = 1;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:spider", 2, 3, java.util.List.of("{ActiveEffects:[{Id:\"minecraft:invisibility\",Amplifier:0b,Duration:600}]}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry golemVsPillagers() {
            var e = new SpawnEntry();
            e.preset = Preset.GOLEM_VS_PILLAGERS;
            e.eventType = EventKind.PATROL;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:iron_golem", 1, 1, java.util.List.of("{Health:25f}")),
                    Group.of("minecraft:vindicator", 2, 2)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry zombieVillagerRescue() {
            var e = new SpawnEntry();
            e.preset = Preset.ZOMBIE_VILLAGER_RESCUE;
            e.eventType = EventKind.AMBUSH;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:zombie_villager", 1, 1),
                    Group.of("minecraft:zombie", 3, 4)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultMerchant() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_MERCHANT;
            e.eventType = EventKind.MERCHANT;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:wandering_trader", 1, 1),
                    Group.of("minecraft:trader_llama", 2, 2)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultPatrol() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_PATROL;
            e.eventType = EventKind.PATROL;
            e.weight = 4;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of("minecraft:iron_golem", 1, 1),
                    Group.of("minecraft:villager", 2, 3)
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultWildlife() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_WILDLIFE;
            e.eventType = EventKind.WILDLIFE;
            e.weight = 3;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:wolf", 3, 5)));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultLostTraveler() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_LOST_TRAVELER;
            e.eventType = EventKind.MERCHANT;
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    Group.of(
                            "minecraft:wandering_trader",
                            1,
                            1,
                            java.util.List.of(
                                    "{CustomName:\"{\\\"text\\\":\\\"Lost Traveler\\\",\\\"color\\\":\\\"gold\\\"}\",CustomNameVisible:1b,HandItems:[{id:\"minecraft:map\",Count:1b},{}],HandDropChances:[0.0f,0.0f],ActiveEffects:[{Id:\"minecraft:speed\",Amplifier:0b,Duration:6000}],Offers:{Recipes:[{buy:{id:\"minecraft:emerald\",Count:20b},sell:{id:\"minecraft:name_tag\",Count:1b},maxUses:1,rewardExp:1b,priceMultiplier:0.05f},{buy:{id:\"minecraft:emerald\",Count:24b},sell:{id:\"minecraft:saddle\",Count:1b},maxUses:1,rewardExp:1b,priceMultiplier:0.1f},{buy:{id:\"minecraft:emerald\",Count:8b},sell:{id:\"minecraft:potion\",Count:1b,tag:{Potion:\"minecraft:night_vision\"}},maxUses:2,rewardExp:1b,priceMultiplier:0.05f},{buy:{id:\"minecraft:emerald\",Count:28b},sell:{id:\"minecraft:echo_shard\",Count:1b},maxUses:1,rewardExp:1b,priceMultiplier:0.1f}]}}"
                            )
                    )
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultWanderingHealer() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_WANDERING_HEALER;
            e.eventType = EventKind.MERCHANT; // Using MERCHANT as it"s a non-hostile event
            e.weight = 2;
            e.groups = new java.util.ArrayList<>(java.util.List.of(Group.of("minecraft:villager", 1, 1, java.util.List.of("{VillagerData:{profession:\"minecraft:cleric\"}}"))));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultGraveyard() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_GRAVEYARD;
            e.eventType = EventKind.AMBUSH;
            e.weight = 5;
            e.groups = new java.util.ArrayList<>(java.util.List.of(
                    // Restless zombies with carved pumpkins, moving slowly
                    Group.of(
                            "minecraft:zombie",
                            2,
                            3,
                            java.util.List.of(
                                    "{ArmorItems:[{},{},{},{id:\"minecraft:carved_pumpkin\",Count:1b}],ActiveEffects:[{Id:\"minecraft:slowness\",Amplifier:0b,Duration:600}]}"
                            )
                    ),
                    // Skeletons wandering the graveyard
                    Group.of(
                            "minecraft:skeleton",
                            1,
                            2,
                            java.util.List.of(
                                    "{ArmorItems:[{},{},{},{id:\"minecraft:carved_pumpkin\",Count:1b}],ActiveEffects:[{Id:\"minecraft:slowness\",Amplifier:0b,Duration:600}]}"
                            )
                    ),
                    // One zombie villager among the graves
                    Group.of(
                            "minecraft:zombie_villager",
                            1,
                            1,
                            java.util.List.of(
                                    "{VillagerData:{profession:\"minecraft:none\"},ActiveEffects:[{Id:\"minecraft:slowness\",Amplifier:0b,Duration:600}]}"
                            )
                    )
            ));
            e.biomeBlacklist = new java.util.ArrayList<>(WATER_BIOMES);
            return e;
        }

        public static SpawnEntry defaultNone() {
            var e = new SpawnEntry();
            e.preset = Preset.DEFAULT_NONE;
            e.eventType = EventKind.NONE;
            e.weight = 10;
            e.groups = new java.util.ArrayList<>();
            return e;
        }

        public void applyPresetNow() {
            var src = fromPreset(this.preset);
            if (src == null) return;
            this.eventType = src.eventType;
            this.weight = src.weight;
            this.groups = src.groups == null ? new java.util.ArrayList<>() : new java.util.ArrayList<>(src.groups);
            this.biomeWhitelist = src.biomeWhitelist == null ? new java.util.ArrayList<>() : new java.util.ArrayList<>(src.biomeWhitelist);
            this.biomeBlacklist = src.biomeBlacklist == null ? new java.util.ArrayList<>() : new java.util.ArrayList<>(src.biomeBlacklist);
        }

        public static SpawnEntry fromPreset(Preset p) {
            if (p == null) return null;
            return switch (p) {
                case DEFAULT_AMBUSH -> defaultAmbush();
                case DEFAULT_ZOMBIE_AMBUSH -> defaultZombieAmbush();
                case DEFAULT_SKELETON_AMBUSH -> defaultSkeletonAmbush();
                case DEFAULT_BANDIT_AMBUSH -> defaultBanditAmbush();
                case IRONCLAD_ZOMBIE_AMBUSH -> ironcladZombieAmbush();
                case PILLAGER_CAPTAIN_AMBUSH -> pillagerCaptainAmbush();
                case WITCH_ESCORT_AMBUSH -> witchEscortAmbush();
                case STRAY_AMBUSH -> strayAmbush();
                case HOSTILE_WOLVES_AMBUSH -> hostileWolvesAmbush();
                case POTION_INFUSED_ZOMBIES -> potionInfusedZombies();
                case WELL_EQUIPPED_SKELETONS -> wellEquippedSkeletons();
                case MINER_ZOMBIE_AMBUSH -> minerZombieAmbush();
                case FARMER_ZOMBIE_AMBUSH -> farmerZombieAmbush();
                case CAVE_SPIDER_AMBUSH -> caveSpiderAmbush();
                case DROWNED_AMBUSH -> drownedAmbush();
                case HUSK_AMBUSH -> huskAmbush();
                case ILLUSIONER_AMBUSH -> illusionerAmbush();
                case EVOKER_AMBUSH -> evokerAmbush();
                case SPEEDY_ZOMBIES -> speedyZombies();
                case TANKY_ZOMBIES -> tankyZombies();
                case CHAINMAIL_ZOMBIES -> chainmailZombies();
                case SHARPNESS_ZOMBIES -> sharpnessZombies();
                case PUNCH_SKELETONS -> punchSkeletons();
                case FLAME_SKELETONS -> flameSkeletons();
                case CHAINMAIL_SKELETONS -> chainmailSkeletons();
                case MELEE_SKELETONS -> meleeSkeletons();
                case POISON_SKELETONS -> poisonSkeletons();
                case SLOWNESS_SKELETONS -> slownessSkeletons();
                case WEAKNESS_SKELETONS -> weaknessSkeletons();
                case SPEEDY_SPIDERS -> speedySpiders();
                case STRENGTH_SPIDERS -> strengthSpiders();
                case INVISIBLE_SPIDERS -> invisibleSpiders();
                case GOLEM_VS_PILLAGERS -> golemVsPillagers();
                case ZOMBIE_VILLAGER_RESCUE -> zombieVillagerRescue();
                case DEFAULT_MERCHANT -> defaultMerchant();
                case DEFAULT_PATROL -> defaultPatrol();
                case DEFAULT_WILDLIFE -> defaultWildlife();
                case DEFAULT_LOST_TRAVELER -> defaultLostTraveler();
                case DEFAULT_WANDERING_HEALER -> defaultWanderingHealer();
                case DEFAULT_GRAVEYARD -> defaultGraveyard();
                case DEFAULT_NONE -> defaultNone();
            };
        }

        public enum Preset {
            DEFAULT_AMBUSH,
            DEFAULT_ZOMBIE_AMBUSH,
            DEFAULT_SKELETON_AMBUSH,
            DEFAULT_BANDIT_AMBUSH,
            IRONCLAD_ZOMBIE_AMBUSH,
            PILLAGER_CAPTAIN_AMBUSH,
            WITCH_ESCORT_AMBUSH,
            STRAY_AMBUSH,
            HOSTILE_WOLVES_AMBUSH,
            POTION_INFUSED_ZOMBIES,
            WELL_EQUIPPED_SKELETONS,
            MINER_ZOMBIE_AMBUSH,
            FARMER_ZOMBIE_AMBUSH,
            CAVE_SPIDER_AMBUSH,
            DROWNED_AMBUSH,
            HUSK_AMBUSH,
            ILLUSIONER_AMBUSH,
            EVOKER_AMBUSH,
            SPEEDY_ZOMBIES,
            TANKY_ZOMBIES,
            CHAINMAIL_ZOMBIES,
            SHARPNESS_ZOMBIES,
            PUNCH_SKELETONS,
            FLAME_SKELETONS,
            CHAINMAIL_SKELETONS,
            MELEE_SKELETONS,
            POISON_SKELETONS,
            SLOWNESS_SKELETONS,
            WEAKNESS_SKELETONS,
            SPEEDY_SPIDERS,
            STRENGTH_SPIDERS,
            INVISIBLE_SPIDERS,
            GOLEM_VS_PILLAGERS,
            ZOMBIE_VILLAGER_RESCUE,
            DEFAULT_MERCHANT,
            DEFAULT_PATROL,
            DEFAULT_WILDLIFE,
            DEFAULT_LOST_TRAVELER,
            DEFAULT_WANDERING_HEALER,
            DEFAULT_GRAVEYARD,
            DEFAULT_NONE
        }
    }

    public static class Group {
        @ConfigEntry.Gui.Tooltip
        public String idOrTag = "minecraft:pillager"; // supports "#namespace:tag" or direct entity id

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
