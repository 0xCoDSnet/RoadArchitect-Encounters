package net.oxcodsnet.roadencounters.fabric.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.oxcodsnet.roadencounters.config.AmbushConfig;
import net.oxcodsnet.roadencounters.config.REConfig;
import net.oxcodsnet.roadencounters.config.REConfigHolder;

public final class QuiltREConfigBridge {
    private QuiltREConfigBridge() {}

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
        if (cfg.mobsMax < cfg.mobsMin) {
            cfg.mobsMax = cfg.mobsMin;
            holder.save();
        }
        REConfigHolder.set(new Impl(holder));
    }

    private record Impl(ConfigHolder<AmbushConfig> holder) implements REConfig {
        @Override public int maxMarkers() { return holder.getConfig().maxMarkers; }
        @Override public int strideBlocks() { return holder.getConfig().strideBlocks; }
        @Override public int triggerRadius() { return holder.getConfig().triggerRadius; }
        @Override public int cooldownSeconds() { return holder.getConfig().cooldownSeconds; }
        @Override public int mobsMin() { return holder.getConfig().mobsMin; }
        @Override public int mobsMax() { return holder.getConfig().mobsMax; }
        @Override public int spawnOffset() { return holder.getConfig().spawnOffset; }
    }
}
