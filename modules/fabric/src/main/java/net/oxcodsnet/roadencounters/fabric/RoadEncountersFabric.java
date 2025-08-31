package net.oxcodsnet.roadencounters.fabric;

import net.fabricmc.api.ModInitializer;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddons;
import net.oxcodsnet.roadencounters.AmbushAddon;
import net.oxcodsnet.roadencounters.fabric.config.FabricREConfigBridge;

public final class RoadEncountersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FabricREConfigBridge.init();
        RoadAddons.registerAddon(new AmbushAddon());
    }
}
