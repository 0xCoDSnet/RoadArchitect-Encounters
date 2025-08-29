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
            case "es_es": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Configuración");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Máximo de marcadores por ruta");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Cuántos desencadenadores colocar a lo largo de una ruta finalizada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Paso a lo largo de la ruta (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distancia a lo largo de la ruta entre marcadores colocados.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Radio de activación (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Distancia de proximidad del jugador para activar la emboscada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Enfriamiento (segundos)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Tiempo antes de que el marcador vuelva a estar listo tras activarse.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Desplazamiento de aparición (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Desplazamiento aleatorio X/Z alrededor del centro del marcador para el spawn.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Opciones de aparición");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Lista de posibles entidades con peso y cantidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "ID de entidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Nombre con espacio de nombres, p. ej. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Peso de probabilidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Mayor peso = mayor probabilidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Mínimo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Máximo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Entrada de aparición");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID de entidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Nombre con espacio de nombres, p. ej. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Peso de probabilidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Mayor peso = mayor probabilidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Mínimo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Máximo");
                break;
            }
            case "fr_fr": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters : Paramètres");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Marqueurs max par route");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Nombre de déclencheurs à placer le long d’une route finalisée.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Pas le long de la route (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distance le long de la route entre les marqueurs placés.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Rayon de déclenchement (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Distance de proximité du joueur pour déclencher l’embuscade.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Temps de recharge (secondes)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Durée avant que le marqueur soit de nouveau prêt après déclenchement.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Décalage d’apparition (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Décalage aléatoire X/Z autour du centre du marqueur pour l’apparition.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Options d'apparition");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Liste des entités possibles avec poids et quantité.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "ID d'entité");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Nom qualifié, ex. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Poids de chance");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Plus le poids est élevé, plus la probabilité est grande.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Nombre min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Nombre max");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Entrée d'apparition");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID d'entité");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Nom qualifié, ex. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Poids de chance");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Plus le poids est élevé, plus la probabilité est grande.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Nombre min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Nombre max");
                break;
            }
            case "de_de": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Einstellungen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Max. Markierungen pro Route");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Wie viele Trigger entlang einer finalisierten Route platziert werden.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Schritt entlang der Route (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Abstand entlang der Route zwischen platzierten Markierungen.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Auslöser-Radius (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Spieler-Nähe, um einen Hinterhalt auszulösen.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Abklingzeit (Sekunden)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Zeit, bis eine Markierung nach dem Auslösen wieder bereit ist.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Spawn-Versatz (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Zufälliger X/Z-Versatz um das Markierungszentrum für Spawns.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Spawn-Optionen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Liste möglicher Entitäten mit Gewicht und Anzahl.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "Entity-ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Namespaced Name, z. B. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Chancen-Gewicht");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Höheres Gewicht = höhere Wahrscheinlichkeit.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Min. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Max. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Spawn-Eintrag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Entity-ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Namespaced Name, z. B. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Chancen-Gewicht");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Höheres Gewicht = höhere Wahrscheinlichkeit.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Min. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Max. Anzahl");
                break;
            }
            case "zh_cn": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters：设置");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "每条路径的最大标记数");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "沿已完成的路径放置多少个触发标记。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "沿路径的步进（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "沿路径放置标记之间的距离。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "触发半径（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "玩家接近到该距离时触发埋伏。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "冷却时间（秒）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "标记触发后再次就绪所需的时间。");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "生成偏移（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "围绕标记中心在 X/Z 方向的随机偏移。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "生成选项");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "可能出现的实体列表及其权重和数量。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "实体ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "带命名空间的名称，例如 minecraft:pillager。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "概率权重");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "权重越高，概率越大。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "最小数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "最大数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "生成条目");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "实体ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "带命名空间的名称，例如 minecraft:pillager。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "概率权重");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "权重越高，概率越大。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "最小数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "最大数量");
                break;
            }
            case "uk_ua": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Налаштування");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Макс. міток на маршрут");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Скільки тригерів розміщувати вздовж завершеного маршруту.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Крок уздовж маршруту (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Відстань уздовж маршруту між розміщеними мітками.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Радіус спрацювання (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Відстань наближення гравця для спрацювання засідки.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Час відновлення (секунди)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Час до повторної готовності мітки після спрацювання.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Зсув появи (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Випадковий зсув по X/Z навколо центру мітки для появи мобів.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Параметри спавну");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Список можливих сутностей з вагою і кількістю.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "ID сутності");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Ім'я з простором назв, напр. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Вага шансу");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Більша вага = більша ймовірність.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Мін. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Макс. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Запис спавну");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID сутності");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Ім'я з простором назв, напр. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Вага шансу");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Більша вага = більша ймовірність.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Мін. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Макс. кількість");
                break;
            }
            case "ru_ru": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Настройки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Макс. маркеров на путь");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Сколько триггеров ставить вдоль одного финализированного пути.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Шаг по пути (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Через какое расстояние вдоль пути ставить следующий маркер.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Радиус срабатывания (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Расстояние, на котором игрок активирует засаду.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Кулдаун (секунды)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Время до повторной готовности маркера после срабатывания.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Разброс спавна (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Случайное смещение по X/Z вокруг центра маркера.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Список спавна");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Сущности, которые могут появиться, с весом и количеством.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "Сущность");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Идентификатор вида minecraft:pillager и т.п.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Шанс (вес)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Чем выше вес, тем выше вероятность выбора.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Мин. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Макс. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Запись спавна");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Сущность");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Идентификатор вида minecraft:pillager и т.п.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Шанс (вес)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Чем выше вес, тем выше вероятность выбора.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Мин. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Макс. кол-во");
                break;
            }
            case "en_us":
            default: {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Settings");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Max markers per path");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "How many triggers to place along a finalized path.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Stride along path (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distance along the path between placed markers.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Trigger radius (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Player proximity distance to fire an ambush.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Cooldown (seconds)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Time before a marker becomes ready again after firing.");
                // removed global mobsMin/mobsMax; per-entry counts are used instead
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Spawn offset (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Random X/Z offset around marker center for spawns.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Spawn options");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "List of possible entities with weight and per-entry count.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "Entity ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Namespaced id, e.g. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Chance weight");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Higher weight = higher pick probability.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Count min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Count max");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Spawn entry");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Entity ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Namespaced id, e.g. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Chance weight");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Higher weight = higher pick probability.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Count min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Count max");
                break;
            }
        }
    }
}
