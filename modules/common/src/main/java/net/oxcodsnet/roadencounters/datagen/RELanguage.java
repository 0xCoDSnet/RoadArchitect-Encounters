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
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters: Configuración");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Máximo de marcadores por ruta");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Cuántos desencadenadores colocar a lo largo de una ruta finalizada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Paso a lo largo de la ruta (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distancia a lo largo de la ruta entre marcadores colocados.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Radio de activación (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Distancia de proximidad del jugador para activar la emboscada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Enfriamiento (segundos)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Tiempo antes de que el marcador vuelva a estar listo tras activarse.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Mín. de mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Cantidad mínima de mobs en una emboscada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Máx. de mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Cantidad máxima de mobs en una emboscada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Desplazamiento de aparición (bloques)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Desplazamiento aleatorio X/Z alrededor del centro del marcador para el spawn.");
                break;
            }
            case "fr_fr": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters : Paramètres");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Marqueurs max par route");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Nombre de déclencheurs à placer le long d’une route finalisée.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Pas le long de la route (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distance le long de la route entre les marqueurs placés.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Rayon de déclenchement (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Distance de proximité du joueur pour déclencher l’embuscade.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Temps de recharge (secondes)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Durée avant que le marqueur soit de nouveau prêt après déclenchement.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Nombre min de mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Nombre minimum de mobs lors d’une embuscade.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Nombre max de mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Nombre maximal de mobs lors d’une embuscade.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Décalage d’apparition (blocs)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Décalage aléatoire X/Z autour du centre du marqueur pour l’apparition.");
                break;
            }
            case "de_de": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters: Einstellungen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Max. Markierungen pro Route");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Wie viele Trigger entlang einer finalisierten Route platziert werden.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Schritt entlang der Route (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Abstand entlang der Route zwischen platzierten Markierungen.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Auslöser-Radius (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Spieler-Nähe, um einen Hinterhalt auszulösen.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Abklingzeit (Sekunden)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Zeit, bis eine Markierung nach dem Auslösen wieder bereit ist.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Min. Anzahl Mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Mindestanzahl an Mobs in einem Hinterhalt.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Max. Anzahl Mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Maximale Anzahl an Mobs in einem Hinterhalt.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Spawn-Versatz (Blöcke)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Zufälliger X/Z-Versatz um das Markierungszentrum für Spawns.");
                break;
            }
            case "zh_cn": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters：设置");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "每条路径的最大标记数");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "沿已完成的路径放置多少个触发标记。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "沿路径的步进（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "沿路径放置标记之间的距离。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "触发半径（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "玩家接近到该距离时触发埋伏。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "冷却时间（秒）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "标记触发后再次就绪所需的时间。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "最少怪物数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "一次埋伏中的最少怪物数量。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "最多怪物数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "一次埋伏中的最多怪物数量。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "生成偏移（方块）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "围绕标记中心在 X/Z 方向的随机偏移。");
                break;
            }
            case "uk_ua": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters: Налаштування");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Макс. міток на маршрут");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Скільки тригерів розміщувати вздовж завершеного маршруту.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Крок уздовж маршруту (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Відстань уздовж маршруту між розміщеними мітками.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Радіус спрацювання (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Відстань наближення гравця для спрацювання засідки.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Час відновлення (секунди)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Час до повторної готовності мітки після спрацювання.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Мін. кількість мобів");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Мінімальна кількість мобів у засідці.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Макс. кількість мобів");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Максимальна кількість мобів у засідці.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Зсув появи (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Випадковий зсув по X/Z навколо центру мітки для появи мобів.");
                break;
            }
            case "ru_ru": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters: Настройки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Макс. маркеров на путь");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "Сколько триггеров ставить вдоль одного финализированного пути.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Шаг по пути (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Через какое расстояние вдоль пути ставить следующий маркер.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Радиус срабатывания (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Расстояние, на котором игрок активирует засаду.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Кулдаун (секунды)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Время до повторной готовности маркера после срабатывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Мин. мобов");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Минимальное количество мобов в засаде.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Макс. мобов");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Максимальное количество мобов в засаде.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Разброс спавна (блоки)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Случайное смещение по X/Z вокруг центра маркера.");
                break;
            }
            case "en_us":
            default: {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "Road Encounters: Settings");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers", "Max markers per path");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.maxMarkers.@Tooltip", "How many triggers to place along a finalized path.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks", "Stride along path (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.strideBlocks.@Tooltip", "Distance along the path between placed markers.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius", "Trigger radius (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.triggerRadius.@Tooltip", "Player proximity distance to fire an ambush.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds", "Cooldown (seconds)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.cooldownSeconds.@Tooltip", "Time before a marker becomes ready again after firing.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin", "Min mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMin.@Tooltip", "Minimum number of mobs in an ambush.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax", "Max mobs");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.mobsMax.@Tooltip", "Maximum number of mobs in an ambush.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset", "Spawn offset (blocks)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawnOffset.@Tooltip", "Random X/Z offset around marker center for spawns.");
                break;
            }
        }
    }
}
