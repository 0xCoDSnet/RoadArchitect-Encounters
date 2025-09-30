package net.oxcodsnet.roadencounters.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.oxcodsnet.roadencounters.datagen.RELanguage;

public final class RoadEncountersLanguageProvider extends FabricLanguageProvider {
    private final String code;

    public RoadEncountersLanguageProvider(FabricDataOutput output, String code) {
        super(output, code);
        this.code = code;
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        RELanguage.fill(this.code, builder::add);
    }
}
