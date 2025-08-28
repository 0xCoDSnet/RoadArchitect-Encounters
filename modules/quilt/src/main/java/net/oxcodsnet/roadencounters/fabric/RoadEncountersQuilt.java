package net.oxcodsnet.roadencounters.fabric;

import net.fabricmc.api.ModInitializer;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddons;
import net.oxcodsnet.roadencounters.AmbushAddon;

public final class RoadEncountersQuilt implements ModInitializer {
    @Override
    public void onInitialize() {
        RoadAddons.registerAddon(new AmbushAddon());
    }
}
