# RoadArchitect: Encounters

- Mod ID: `roadarchitect_roadencounters`
- Minecraft: 1.21.x
- Loaders: Fabric, NeoForge, Quilt (Architectury)

RoadArchitect: Encounters adds dynamic ambient events along roads built by RoadArchitect. When a planned path is finalized, the addon places lightweight one‑shot markers. As a player approaches a marker (≤75 blocks) and the chunk is loaded, the marker fires an encounter — e.g., a small 4–5 pillager ambush — and then removes itself. Encounters are sparse, non‑intrusive and only trigger near roads to keep gameplay balanced and performance friendly.

Key points:
- Uses the official RoadArchitect addon API (no core patches).
- Markers are stored as PersistentState; each marker fires once.
- All proximity and chunk checks run server‑side; no blocking I/O.
- Fully deterministic with Minecraft random per world tick.

Requirements:
- Java 21.
- RoadArchitect installed in the same instance (all loaders supported).

Build & Dev:
1) Publish RoadArchitect locally once: `./gradlew publishToMavenLocal` in the RA repo.
2) Build this addon: `./gradlew build`.
3) Dev‑run with RoadArchitect on classpath:
   - Fabric: `./gradlew :modules:fabric:runClient`
   - Quilt: `./gradlew :modules:quilt:runClient`
   - NeoForge: `./gradlew :modules:neoforge:runClient`

Defaults:
- Trigger radius: 75 blocks.
- Ambush size: 4–5 pillagers.
- Markers per path: up to 3; ~160 block stride.

Future: expose config to tune frequency, radius and encounter presets.
