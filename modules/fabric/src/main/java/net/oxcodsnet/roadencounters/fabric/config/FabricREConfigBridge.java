package net.oxcodsnet.roadencounters.fabric.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.oxcodsnet.roadencounters.config.AmbushConfig;
import net.oxcodsnet.roadencounters.config.REConfig;
import net.oxcodsnet.roadencounters.config.REConfigHolder;

public final class FabricREConfigBridge {
    private FabricREConfigBridge() {}

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
                if (e.countMax < e.countMin) { e.countMax = e.countMin; changed = true; }
                if (e.weight < 0) { e.weight = 0; changed = true; }
            }
        }
        if (cfg.spawns == null || cfg.spawns.isEmpty()) {
            cfg.spawns = new java.util.ArrayList<>(java.util.List.of(AmbushConfig.SpawnEntry.defaultPillager()));
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
        @Override public java.util.List<REConfig.SpawnSpec> spawnSpecs() {
            var c = holder.getConfig();
            java.util.ArrayList<REConfig.SpawnSpec> out = new java.util.ArrayList<>();
            if (c.spawns != null) for (var e : c.spawns) {
                out.add(new REConfig.SpawnSpec(e.entityId, e.weight, e.countMin, e.countMax));
            }
            return java.util.Collections.unmodifiableList(out);
        }
    }
}
