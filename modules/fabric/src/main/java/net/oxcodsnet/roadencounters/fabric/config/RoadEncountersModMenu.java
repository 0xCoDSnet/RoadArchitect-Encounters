package net.oxcodsnet.roadencounters.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.oxcodsnet.roadencounters.config.AmbushConfig;
import net.oxcodsnet.roadencounters.config.EventKind;
import net.oxcodsnet.roadencounters.fabric.config.FabricREConfigBridge;

public final class RoadEncountersModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            // Ensure config system is initialized before opening the screen
            FabricREConfigBridge.init();
            try {
                AutoConfig.getConfigHolder(AmbushConfig.class);
            } catch (Throwable t) {
                AutoConfig.register(AmbushConfig.class, GsonConfigSerializer::new);
            }
            var registry = AutoConfig.getGuiRegistry(AmbushConfig.class);
            registry.registerTypeProvider((i18n, field, config, defaults, gui) -> {
                var eb = ConfigEntryBuilder.create();
                EventKind current;
                try {
                    current = (EventKind) field.get(config);
                } catch (IllegalAccessException e) {
                    current = EventKind.AMBUSH;
                }
                var entry = eb.startEnumSelector(
                                Text.translatable(i18n),
                                EventKind.class,
                                current == null ? EventKind.AMBUSH : current)
                        .setDefaultValue(EventKind.AMBUSH)
                        .setSaveConsumer(v -> {
                            try { field.set(config, v); } catch (IllegalAccessException ignored) {}
                        })
                        .build();
                return java.util.List.of(entry);
            }, EventKind.class);
            return AutoConfig.getConfigScreen(AmbushConfig.class, parent).get();
        };
    }
}
