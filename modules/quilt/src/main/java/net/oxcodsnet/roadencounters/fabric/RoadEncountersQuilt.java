package net.oxcodsnet.roadencounters.fabric;

import net.fabricmc.api.ModInitializer;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddons;
import net.oxcodsnet.roadencounters.AmbushAddon;
import net.oxcodsnet.roadencounters.fabric.config.QuiltREConfigBridge;

public final class RoadEncountersQuilt implements ModInitializer {
    @Override
    public void onInitialize() {
        QuiltREConfigBridge.init();
        RoadAddons.registerAddon(new AmbushAddon());
    }
}
