package net.oxcodsnet.roadencounters.neoforge.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.fml.ModLoadingContext;
import net.oxcodsnet.roadencounters.config.AmbushConfig;
import net.oxcodsnet.roadencounters.config.EventKind;

public final class RoadEncountersNeoForgeClient {
    private RoadEncountersNeoForgeClient() {}

    public static void registerConfigScreen() {
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

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class,
                () -> (mc, parent) -> AutoConfig.getConfigScreen(AmbushConfig.class, parent).get());
    }
}
