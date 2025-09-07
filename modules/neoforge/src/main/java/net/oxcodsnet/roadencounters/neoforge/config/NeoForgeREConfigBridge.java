package net.oxcodsnet.roadencounters.neoforge.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.oxcodsnet.roadencounters.config.AmbushConfig;
import net.oxcodsnet.roadencounters.config.REConfig;
import net.oxcodsnet.roadencounters.config.REConfigHolder;

public final class NeoForgeREConfigBridge {
    private NeoForgeREConfigBridge() {}

    public static void init() {
        ConfigHolder<AmbushConfig> holder;
        try {
            holder = AutoConfig.getConfigHolder(AmbushConfig.class);
        } catch (Throwable e) {
            AutoConfig.register(AmbushConfig.class, GsonConfigSerializer::new);
            holder = AutoConfig.getConfigHolder(AmbushConfig.class);
        }
        ensureBoundsAndPublish(holder);
    }

    private static void ensureBoundsAndPublish(ConfigHolder<AmbushConfig> holder) {
        var cfg = holder.getConfig();
        // sanitize spawn entries
        boolean changed = false;
        if (cfg.spawns != null) {
            for (var e : cfg.spawns) {
                if (e.weight < 0) { e.weight = 0; changed = true; }
                if (e.groups == null || e.groups.isEmpty()) {
                    e.groups = new java.util.ArrayList<>(java.util.List.of(AmbushConfig.Group.of("minecraft:pillager", 4, 5)));
                    changed = true;
                } else {
                    for (var g : e.groups) {
                        if (g.countMax < g.countMin) { g.countMax = g.countMin; changed = true; }
                        if (g.countMin < 0) { g.countMin = 0; changed = true; }
                    }
                }
            }
        }
        if (cfg.spawns == null || cfg.spawns.isEmpty()) {
            cfg.spawns = new java.util.ArrayList<>(java.util.List.of(AmbushConfig.SpawnEntry.defaultAmbush()));
            changed = true;
        }
        if (changed) holder.save();
        REConfigHolder.set(new Impl(holder));
    }

    private record Impl(ConfigHolder<AmbushConfig> holder) implements REConfig {
        @Override public int maxMarkers() { return holder.getConfig().maxMarkers; }
        @Override public int strideBlocks() { return holder.getConfig().strideBlocks; }
        @Override public int triggerRadius() { return holder.getConfig().triggerRadius; }
        @Override public int cooldownSeconds() { return holder.getConfig().cooldownSeconds; }
        @Override public int spawnOffset() { return holder.getConfig().spawnOffset; }
        @Override public boolean debugActionbar() { return holder.getConfig().debugActionbar; }
        @Override public java.util.List<REConfig.EncounterSpec> encounterSpecs() {
            var c = holder.getConfig();
            java.util.ArrayList<REConfig.EncounterSpec> out = new java.util.ArrayList<>();
            if (c.spawns != null) for (var e : c.spawns) {
                java.util.ArrayList<REConfig.Group> groups = new java.util.ArrayList<>();
                if (e.groups != null) for (var g : e.groups) {
                    groups.add(new REConfig.Group(g.idOrTag, g.countMin, g.countMax));
                }
                out.add(new REConfig.EncounterSpec(e.eventType, e.weight, java.util.Collections.unmodifiableList(groups)));
            }
            return java.util.Collections.unmodifiableList(out);
        }
    }
}
