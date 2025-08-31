package net.oxcodsnet.roadencounters.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.oxcodsnet.roadencounters.config.AmbushConfig;

public final class RoadEncountersModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            // Ensure config system is initialized before opening the screen
            QuiltREConfigBridge.init();
            return AutoConfig.getConfigScreen(AmbushConfig.class, parent).get();
        };
    }
}
