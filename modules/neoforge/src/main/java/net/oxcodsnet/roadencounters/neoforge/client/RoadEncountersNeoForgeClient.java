package net.oxcodsnet.roadencounters.neoforge.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.fml.ModLoadingContext;
import net.oxcodsnet.roadencounters.config.AmbushConfig;

public final class RoadEncountersNeoForgeClient {
    private RoadEncountersNeoForgeClient() {}

    public static void registerConfigScreen() {
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class,
                () -> (mc, parent) -> AutoConfig.getConfigScreen(AmbushConfig.class, parent).get());
    }
}
