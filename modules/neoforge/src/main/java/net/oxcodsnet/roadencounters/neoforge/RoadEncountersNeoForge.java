package net.oxcodsnet.roadencounters.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.oxcodsnet.roadarchitect.api.addon.RoadAddons;
import net.oxcodsnet.roadencounters.AmbushAddon;
import net.oxcodsnet.roadencounters.neoforge.client.RoadEncountersNeoForgeClient;
import net.oxcodsnet.roadencounters.neoforge.config.NeoForgeREConfigBridge;

@Mod("roadencounters")
public final class RoadEncountersNeoForge {
    public RoadEncountersNeoForge(IEventBus modBus, ModContainer container, Dist dist) {
        NeoForgeREConfigBridge.init();
        RoadAddons.registerAddon(new AmbushAddon());
        if (dist == Dist.CLIENT) {
            RoadEncountersNeoForgeClient.registerConfigScreen();
        }
    }
}
