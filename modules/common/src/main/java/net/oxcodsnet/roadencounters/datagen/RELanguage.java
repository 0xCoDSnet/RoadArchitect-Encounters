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
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "Ajustes generales");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Entradas de Aparición");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Tipos de evento");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Mostrar mensajes de eventos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Alternar mensajes en la barra de acción en la parte inferior.");
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
                // event weights (fallback to English if untranslated)
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Tipo de evento (pesos)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Probabilidades relativas de distintos encuentros.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Entrada de evento");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Tipo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "Uno de: ambush, merchant, patrol, wildlife, none.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Peso de probabilidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Mayor peso = mayor probabilidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Emboscada");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Comerciantes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Patrulla");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Fauna");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "Ninguno");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Opciones de aparición");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Lista de posibles entidades con peso y cantidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "ID de entidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Nombre con espacio de nombres, p. ej. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Peso de probabilidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Mayor peso = mayor probabilidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Mínimo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Máximo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Entrada de aparición");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Preajuste");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Plantillas predefinidas para eventos. ¡Seleccionar un preajuste sobrescribirá los valores a continuación!");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID de entidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Nombre con espacio de nombres, p. ej. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Peso de probabilidad");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Mayor peso = mayor probabilidad.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Mínimo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Máximo");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Tipo de evento");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Tipo de evento para esta entrada.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Grupos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "Lista de grupos de entidades con cantidades y NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Lista blanca de biomas");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Biomas donde puede aparecer este encuentro.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Lista negra de biomas");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Biomas donde este encuentro no aparecerá.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID o etiqueta");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "ID de entidad (p. ej. minecraft:pillager) o #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Grupos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "Lista de IDs de entidades o etiquetas con cantidades por grupo.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Tipo de evento");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "Datos NBT para el mob, en formato JSON. Se recomienda usar un editor externo para escribir el JSON y luego pegarlo aquí.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "¡Peligro! Emboscada más adelante.");
                add.accept("message.roadarchitect_roadencounters.merchant", "Te encuentras con mercaderes ambulantes.");
                add.accept("message.roadarchitect_roadencounters.patrol", "Una patrulla pasa por aquí.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Fauna cercana.");
                add.accept("message.roadarchitect_roadencounters.none", "Todo despejado. Nada inusual.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Tipos de evento");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Emboscada");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Comerciantes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Patrulla");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Fauna");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "Ninguno");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Sonidos");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "Lista de IDs de sonido para reproducir.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Grupo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID o etiqueta");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "ID de entidad (p. ej. minecraft:pillager) o #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Mínimo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Cantidad mínima de entidades en este grupo.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Máximo");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Cantidad máxima de entidades en este grupo.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "Datos NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "Datos NBT para el mob, en formato JSON. Se recomienda usar un editor externo para escribir el JSON y luego pegarlo aquí.");
                break;
            }
            case "fr_fr": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters : Paramètres");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "Paramètres généraux");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Entrées d'apparition");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Types d'événements");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Afficher les messages d'événement");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Activer/désactiver les messages en bas de l'écran.");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Préréglage");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Modèles prédéfinis pour les événements. La sélection d'un préréglage écrasera les valeurs ci-dessous !");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID d'entité");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Nom qualifié, ex. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Poids de chance");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Plus le poids est élevé, plus la probabilité est grande.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Nombre min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Nombre max");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Type d'événement");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Type d'événement pour cette entrée.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Groupes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "Liste de groupes d'entités avec quantités et NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Liste blanche de biomes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Biomes où cette rencontre peut apparaître.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Liste noire de biomes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Biomes où cette rencontre n'apparaîtra pas.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Entrée d'événement");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Type");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "Parmi: ambush, merchant, patrol, wildlife, none.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Poids de chance");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Plus le poids est élevé, plus la probabilité est grande.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Types d'événements (pondérations)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Probabilités relatives des différentes rencontres en bord de route.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Embuscade");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Marchands");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Patrouille");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Faune");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "Aucun");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Groupes");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "Liste d’IDs d’entités ou de tags avec des quantités par groupe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID ou tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "ID d’entité (p. ex. minecraft:pillager) ou #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Type d’événement");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "Données NBT pour le mob, au format JSON. Il est recommandé d'utiliser un éditeur externe pour écrire le JSON, puis de le coller ici.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "Danger ! Embuscade droit devant.");
                add.accept("message.roadarchitect_roadencounters.merchant", "Vous rencontrez des marchands ambulants.");
                add.accept("message.roadarchitect_roadencounters.patrol", "Une patrouille passe par là.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Faune à proximité.");
                add.accept("message.roadarchitect_roadencounters.none", "Rien à signaler. Rien d'inhabituel.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Types d'événements");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Embuscade");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Marchands");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Patrouille");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Faune");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "Aucun");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Sons");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "Liste des IDs de sons à jouer.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "List of sound ids to play.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Groupe");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID ou tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "ID d'entité (ex. minecraft:pillager) ou #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Nombre min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Nombre minimum d’entités dans ce groupe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Nombre max");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Nombre maximal d’entités dans ce groupe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "Données NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "Données NBT pour le mob, au format JSON. Il est recommandé d’utiliser un éditeur externe pour écrire le JSON, puis de le coller ici.");
                break;
            }
            case "de_de": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Einstellungen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "Allgemeine Einstellungen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Spawn-Einträge");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Ereignistypen");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Ereignismeldungen anzeigen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Ein-/Ausblenden der Meldungen unten am Bildschirm.");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Voreinstellung");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Vordefinierte Vorlagen für Ereignisse. Das Auswählen einer Voreinstellung überschreibt die folgenden Werte!");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Entity-ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Namespaced Name, z. B. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Chancen-Gewicht");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Höheres Gewicht = höhere Wahrscheinlichkeit.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Min. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Max. Anzahl");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Ereignistyp");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Ereignistyp für diesen Eintrag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Gruppen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "Liste von Entity-Gruppen mit Anzahl und NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Biom-Zulassungsliste");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Biome, in denen diese Begegnung erscheinen kann.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Biom-Sperrliste");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Biome, in denen diese Begegnung nicht erscheint.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Ereignis-Eintrag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Typ");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "Eines von: ambush, merchant, patrol, wildlife, none.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Chancen-Gewicht");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Höheres Gewicht = höhere Wahrscheinlichkeit.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Ereignistypen (Gewichtungen)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Relative Wahrscheinlichkeiten verschiedener Begegnungen am Wegesrand.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Hinterhalt");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Händler");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Patrouille");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Wildtiere");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "Keine");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Gruppen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "Liste von Entitäts-IDs oder Tags mit Anzahlen pro Gruppe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID oder Tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "Entity-ID (z. B. minecraft:pillager) oder #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Ereignistyp");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "NBT-Daten für den Mob im JSON-Format. Es wird empfohlen, einen externen Editor zu verwenden, um das JSON zu schreiben und es dann hier einzufügen.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "Gefahr! Hinterhalt voraus.");
                add.accept("message.roadarchitect_roadencounters.merchant", "Du triffst reisende Händler.");
                add.accept("message.roadarchitect_roadencounters.patrol", "Eine Patrouille kommt vorbei.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Wildtiere in der Nähe.");
                add.accept("message.roadarchitect_roadencounters.none", "Alles klar. Nichts Ungewöhnliches.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Ereignistypen");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Hinterhalt");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Händler");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Patrouille");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Wildtiere");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "Keine");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Klänge");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "Liste der abzuspielenden Sound-IDs.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "List of sound ids to play.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Gruppe");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID oder Tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "Entity-ID (z. B. minecraft:pillager) oder #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Min. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Minimale Anzahl an Entitäten in dieser Gruppe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Max. Anzahl");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Maximale Anzahl an Entitäten in dieser Gruppe.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "NBT-Daten");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "NBT-Daten für den Mob im JSON-Format. Es wird empfohlen, einen externen Editor zu verwenden, um das JSON zu schreiben und es dann hier einzufügen.");
                break;
            }
            case "zh_cn": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters：设置");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "常规设置");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "生成条目");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "事件类型");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "显示事件消息");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "切换底部行动栏消息。");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "预设");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "事件的预定义模板。选择预设将覆盖以下值！");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "实体ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "带命名空间的名称，例如 minecraft:pillager。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "概率权重");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "权重越高，概率越大。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "最小数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "最大数量");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "事件类型");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "此条目的事件类型。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "分组");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "实体分组列表，包含数量与 NBT。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "生物群系白名单");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "该遭遇可能出现的生物群系。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "生物群系黑名单");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "该遭遇不会出现的生物群系。");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "事件条目");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "类型");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "可选：ambush、merchant、patrol、wildlife、none。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "概率权重");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "权重越高，概率越大。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "事件类型（权重）");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "不同路边遭遇的相对概率。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "伏击");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "商人");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "巡逻");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "野生动物");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "无");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "分组");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "实体ID或标签及各组数量的列表。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID或标签");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "实体ID（例如 minecraft:pillager）或 #namespace:tag。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "事件类型");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "生物的 NBT 数据，JSON 格式。建议使用外部编辑器编写 JSON，然后粘贴到此处。");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "危险！前方有埋伏。");
                add.accept("message.roadarchitect_roadencounters.merchant", "你遇到了旅行商人。");
                add.accept("message.roadarchitect_roadencounters.patrol", "一队巡逻队经过。");
                add.accept("message.roadarchitect_roadencounters.wildlife", "附近有野生动物。");
                add.accept("message.roadarchitect_roadencounters.none", "一切正常。没什么特别的。");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "事件类型");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "伏击");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "商人");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "巡逻");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "野生动物");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "无");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "声音");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "要播放的声音ID列表。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "List of sound ids to play.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "分组");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID或标签");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "实体ID（如 minecraft:pillager）或 #namespace:tag。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "最小数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "该分组中实体的最小数量。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "最大数量");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "该分组中实体的最大数量。");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "生物的 NBT 数据，JSON 格式。建议使用外部编辑器编写 JSON，然后粘贴到此处。");
                break;
            }
            case "uk_ua": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Налаштування");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "Основні налаштування");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Записи Спавну");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Типи подій");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Показувати повідомлення подій");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Увімк./вимк. повідомлення внизу екрана.");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Предустановка");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Попередньо визначені шаблони для подій. Вибір предустановки перезапише значення нижче!");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "ID сутності");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Ім'я з простором назв, напр. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Вага шансу");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Більша вага = більша ймовірність.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Мін. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Макс. кількість");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Тип події");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Тип події для цього запису.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Групи");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "Список груп сутностей з кількостями та NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Дозволені біоми");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Біоми, де зустріч може з'являтися.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Заборонені біоми");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Біоми, де зустріч не з'явиться.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Запис події");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Тип");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "Одне з: ambush, merchant, patrol, wildlife, none.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Вага шансу");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Більша вага = більша ймовірність.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Типи подій (ваги)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Відносні ймовірності різних придорожніх зустрічей.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Засідка");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Торговці");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Патруль");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Дика природа");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "Нічого");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Групи");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "Список ID сутностей або тегів з кількістю на групу.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID або тег");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "ID сутності (напр. minecraft:pillager) або #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Тип події");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "NBT-дані для моба, у форматі JSON. Рекомендується використовувати зовнішній редактор для написання JSON, а потім вставити його сюди.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "Небезпека! Попереду засідка.");
                add.accept("message.roadarchitect_roadencounters.merchant", "Ви зустріли мандрівних торговців.");
                add.accept("message.roadarchitect_roadencounters.patrol", "Повз проходить патруль.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Поруч дикі тварини.");
                add.accept("message.roadarchitect_roadencounters.none", "Все чисто. Нічого незвичайного.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Типи подій");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Засідка");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Торговці");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Патруль");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Дика природа");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "Нічого");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "Список ID звуків для відтворення.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "Список ID звуків для відтворення.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "Список ID звуків для відтворення.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "Список ID звуків для відтворення.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "Список ID звуків для відтворення.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "Список ID звуків для відтворення.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Група");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID або тег");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "ID сутності (напр. minecraft:pillager) або #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Мін. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Мінімальна кількість сутностей у цій групі.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Макс. кількість");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Максимальна кількість сутностей у цій групі.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "NBT-дані для моба, у форматі JSON. Рекомендується використовувати зовнішній редактор для написання JSON, а потім вставити його сюди.");
                break;
            }
            case "ru_ru": {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Настройки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "Основные настройки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Записи Спавна");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Список типов");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Подписи событий на экране");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Показывать/скрывать сообщения о событиях внизу экрана.");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Типы событий (вес)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Относительные вероятности разных встреч на дороге.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Запись события");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Тип");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "ambush, merchant, patrol, wildlife, none");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Вес шанса");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Больше вес — выше вероятность выбора.");
                // unified spawns (per-entry event + groups)
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Тип события");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Группы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "Список id или тегов сущностей с количеством для каждой группы.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID или тег");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "Идентификатор (minecraft:pillager) или тег (#namespace:tag).");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "NBT-данные для моба, в формате JSON. Рекомендуется использовать внешний редактор для написания JSON, а затем вставить его сюда.");
                // type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Засада");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Торговцы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Патруль");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Дикая природа");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "Без события");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "Список id звуков для проигрывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Засада");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Торговцы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Патруль");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Дикая природа");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "Без события");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Список спавна");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "Сущности, которые могут появиться, с весом и количеством.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "Сущность");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Идентификатор вида minecraft:pillager и т.п.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Шанс (вес)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Чем выше вес, тем выше вероятность выбора.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Мин. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Макс. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Запись спавна");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Предустановка");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Предопределенные шаблоны для событий. Выбор предустановки перезапишет значения ниже!");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Сущность");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Идентификатор вида minecraft:pillager и т.п.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Шанс (вес)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Чем выше вес, тем выше вероятность выбора.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Мин. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Макс. кол-во");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Тип события");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Тип события для этой записи.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Группы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "Список групп сущностей с количествами и NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Разрешённые биомы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Список биомов, где встреча может появляться.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Запрещённые биомы");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Список биомов, где встреча не появится.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "Опасность! Впереди засада.");
                add.accept("message.roadarchitect_roadencounters.merchant", "На дороге встречены торговцы.");
                add.accept("message.roadarchitect_roadencounters.patrol", "Мимо проходит патруль.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Поблизости замечены животные.");
                add.accept("message.roadarchitect_roadencounters.none", "Спокойно. Вроде ничего особенного.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Типы событий");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "Список ID звуков для проигрывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "Список ID звуков для проигрывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "Список ID звуков для проигрывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "Список ID звуков для проигрывания.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Звуки");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "Список ID звуков для проигрывания.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Группа");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID или тег");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "Идентификатор (minecraft:pillager) или #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Мин. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Минимальное число сущностей в этой группе.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Макс. кол-во");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Максимальное число сущностей в этой группе.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "NBT-данные для моба в формате JSON. Рекомендуется писать JSON во внешнем редакторе и вставлять сюда.");
                break;
            }
            case "en_us":
            default: {
                add.accept("text.autoconfig.roadarchitect_roadencounters.title", "RoadArchitect: Encounters: Settings");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.default", "General");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.spawns", "Spawn Entries");
                add.accept("text.autoconfig.roadarchitect_roadencounters.category.types", "Event Types");
                // debug toggle
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar", "Show event messages");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.debugActionbar.@Tooltip", "Toggle actionbar messages at the bottom of the screen.");
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
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events", "Event types (weights)");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.@Tooltip", "Relative probabilities of different roadside encounters.");
                // list entry for events
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry", "Event entry");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type", "Type");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.type.@Tooltip", "One of: ambush, merchant, patrol, wildlife, none.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight", "Chance weight");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.EventEntry.weight.@Tooltip", "Higher weight = higher pick probability.");
                // unified spawns (per-entry event + groups)
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.eventType", "Event type");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups", "Groups");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.@Tooltip", "List of entity ids or tags with per-group counts.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag", "ID or tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.idOrTag.@Tooltip", "Entity id (e.g. minecraft:pillager) or #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.groups.nbt", "NBT data for the mob, in JSON format. It's recommended to use an external editor to write the JSON and then paste it here.");
                // type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush", "Ambush");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant", "Merchants");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol", "Patrol");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife", "Wildlife");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none", "None");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.ambush", "Ambush");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.merchant", "Merchants");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.patrol", "Patrol");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.wildlife", "Wildlife");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.events.none", "None");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns", "Spawn options");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.@Tooltip", "List of possible entities with weight and per-entry count.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId", "Entity ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.entityId.@Tooltip", "Namespaced id, e.g. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight", "Chance weight");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.weight.@Tooltip", "Higher weight = higher pick probability.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMin", "Count min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.spawns.countMax", "Count max");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry", "Spawn entry");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset", "Preset");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.preset.@Tooltip", "Pre-defined templates for events. Selecting a preset will overwrite the values below!");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId", "Entity ID");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.entityId.@Tooltip", "Namespaced id, e.g. minecraft:pillager.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight", "Chance weight");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.weight.@Tooltip", "Higher weight = higher pick probability.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMin", "Count min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.countMax", "Count max");
                // new SpawnEntry fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType", "Event type");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.eventType.@Tooltip", "Type of event for this entry.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups", "Groups");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.groups.@Tooltip", "List of entity groups with counts and NBT.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist", "Biome whitelist");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeWhitelist.@Tooltip", "Biomes where this encounter may appear.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist", "Biome blacklist");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.SpawnEntry.biomeBlacklist.@Tooltip", "Biomes where this encounter will not appear.");
                // encounter messages
                add.accept("message.roadarchitect_roadencounters.ambush", "Danger! Ambush ahead.");
                add.accept("message.roadarchitect_roadencounters.merchant", "You meet traveling merchants.");
                add.accept("message.roadarchitect_roadencounters.patrol", "A patrol passes by.");
                add.accept("message.roadarchitect_roadencounters.wildlife", "Wildlife nearby.");
                add.accept("message.roadarchitect_roadencounters.none", "All clear. Nothing unusual.");
                // types root label + per-type sounds
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types", "Event Types");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.ambush.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.merchant.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.patrol.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.wildlife.sounds.@Tooltip", "List of sound ids to play.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds", "Sounds");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.types.none.sounds.@Tooltip", "List of sound ids to play.");
                // Group object + fields
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group", "Group");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag", "ID or tag");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.idOrTag.@Tooltip", "Entity id (e.g. minecraft:pillager) or #namespace:tag.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin", "Count min");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMin.@Tooltip", "Minimum number of entities in this group.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax", "Count max");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.countMax.@Tooltip", "Maximum number of entities in this group.");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt", "NBT");
                add.accept("text.autoconfig.roadarchitect_roadencounters.option.Group.nbt.@Tooltip", "NBT data for the mob, in JSON format. It's recommended to use an external editor to write the JSON and then paste it here.");
                break;
            }
        }
    }
}
