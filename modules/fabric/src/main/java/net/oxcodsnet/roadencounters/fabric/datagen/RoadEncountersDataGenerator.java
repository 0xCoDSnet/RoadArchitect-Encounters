package net.oxcodsnet.roadencounters.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public final class RoadEncountersDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "en_us"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "ru_ru"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "es_es"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "fr_fr"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "de_de"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "zh_cn"));
        pack.addProvider((FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) ->
                new RoadEncountersLanguageProvider(out, reg, "uk_ua"));
    }
}
