package net.oxcodsnet.roadencounters.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
public final class RoadEncountersDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "en_us"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "ru_ru"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "es_es"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "fr_fr"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "de_de"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "zh_cn"));
        pack.addProvider((FabricDataOutput out) -> new RoadEncountersLanguageProvider(out, "uk_ua"));
    }
}
