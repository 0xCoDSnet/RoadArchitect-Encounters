# RoadArchitect: Encounters

- Mod ID: `roadarchitect_roadencounters`
- Minecraft: 1.21.x
- Loaders: Fabric, NeoForge, Quilt (Architectury)

This is an addon to Roadarchitect, which adds more life to the road. Along the way, robbers, merchants and other random meetings may meet you.
Key points:
- Uses the official RoadArchitect addon API (no core patches).
- Markers are stored as PersistentState; each marker fires once.
- All proximity and chunk checks run server‑side; no blocking I/O.
- Configurable spawn list: entity, weight and count per entry.
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

Config is available in-game (Cloth Config/Mod Menu) and via file.
