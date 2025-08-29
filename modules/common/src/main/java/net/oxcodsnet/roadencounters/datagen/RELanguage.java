package net.oxcodsnet.roadencounters.datagen;

import java.util.function.BiConsumer;

/**
 * Language keys/values for the addon (config UI, etc.).
 * Platform providers just call fill(locale, builder::add).
 */
public final class RELanguage {
    private RELanguage() {}

    public static void fill(String code, BiConsumer<String, String> add) {
        switch (code) {
            case "ru_ru": {
                add.accept("text.autoconfig.roadencounters.title", "Road Encounters: Настройки");
                add.accept("text.autoconfig.roadencounters.option.maxMarkers", "Макс. маркеров на путь");
                add.accept("text.autoconfig.roadencounters.option.maxMarkers.@Tooltip", "Сколько триггеров ставить вдоль одного финализированного пути.");
                add.accept("text.autoconfig.roadencounters.option.strideBlocks", "Шаг по пути (блоки)");
                add.accept("text.autoconfig.roadencounters.option.strideBlocks.@Tooltip", "Через какое расстояние вдоль пути ставить следующий маркер.");
                add.accept("text.autoconfig.roadencounters.option.triggerRadius", "Радиус срабатывания (блоки)");
                add.accept("text.autoconfig.roadencounters.option.triggerRadius.@Tooltip", "Расстояние, на котором игрок активирует засаду.");
                add.accept("text.autoconfig.roadencounters.option.cooldownSeconds", "Кулдаун (секунды)");
                add.accept("text.autoconfig.roadencounters.option.cooldownSeconds.@Tooltip", "Время до повторной готовности маркера после срабатывания.");
                add.accept("text.autoconfig.roadencounters.option.mobsMin", "Мин. мобов");
                add.accept("text.autoconfig.roadencounters.option.mobsMin.@Tooltip", "Минимальное количество мобов в засаде.");
                add.accept("text.autoconfig.roadencounters.option.mobsMax", "Макс. мобов");
                add.accept("text.autoconfig.roadencounters.option.mobsMax.@Tooltip", "Максимальное количество мобов в засаде.");
                add.accept("text.autoconfig.roadencounters.option.spawnOffset", "Разброс спавна (блоки)");
                add.accept("text.autoconfig.roadencounters.option.spawnOffset.@Tooltip", "Случайное смещение по X/Z вокруг центра маркера.");
                break;
            }
            case "en_us":
            default: {
                add.accept("text.autoconfig.roadencounters.title", "Road Encounters: Settings");
                add.accept("text.autoconfig.roadencounters.option.maxMarkers", "Max markers per path");
                add.accept("text.autoconfig.roadencounters.option.maxMarkers.@Tooltip", "How many triggers to place along a finalized path.");
                add.accept("text.autoconfig.roadencounters.option.strideBlocks", "Stride along path (blocks)");
                add.accept("text.autoconfig.roadencounters.option.strideBlocks.@Tooltip", "Distance along the path between placed markers.");
                add.accept("text.autoconfig.roadencounters.option.triggerRadius", "Trigger radius (blocks)");
                add.accept("text.autoconfig.roadencounters.option.triggerRadius.@Tooltip", "Player proximity distance to fire an ambush.");
                add.accept("text.autoconfig.roadencounters.option.cooldownSeconds", "Cooldown (seconds)");
                add.accept("text.autoconfig.roadencounters.option.cooldownSeconds.@Tooltip", "Time before a marker becomes ready again after firing.");
                add.accept("text.autoconfig.roadencounters.option.mobsMin", "Min mobs");
                add.accept("text.autoconfig.roadencounters.option.mobsMin.@Tooltip", "Minimum number of mobs in an ambush.");
                add.accept("text.autoconfig.roadencounters.option.mobsMax", "Max mobs");
                add.accept("text.autoconfig.roadencounters.option.mobsMax.@Tooltip", "Maximum number of mobs in an ambush.");
                add.accept("text.autoconfig.roadencounters.option.spawnOffset", "Spawn offset (blocks)");
                add.accept("text.autoconfig.roadencounters.option.spawnOffset.@Tooltip", "Random X/Z offset around marker center for spawns.");
                break;
            }
        }
    }
}

