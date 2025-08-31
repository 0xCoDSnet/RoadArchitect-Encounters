package net.oxcodsnet.roadencounters.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.oxcodsnet.roadencounters.datagen.RELanguage;

import java.util.concurrent.CompletableFuture;

public final class RoadEncountersLanguageProvider extends FabricLanguageProvider {
    private final String code;

    public RoadEncountersLanguageProvider(FabricDataOutput output,
                                          CompletableFuture<RegistryWrapper.WrapperLookup> registries,
                                          String code) {
        super(output, code, registries);
        this.code = code;
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registries, TranslationBuilder builder) {
        RELanguage.fill(this.code, builder::add);
    }
}

