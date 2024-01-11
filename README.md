# Crossbow Revamp Plugin

This plugin provides a mechanism to buff the crossbows in Minecraft in a way that feels vanilla.

![Crossbow](./crossbow.webp)

## Config

When running the project for the first time a `config.yml` will be generated in the plugin directory.

```yml
# How much to multiple crossbow projectiles velocity by
# This makes projectiles fired from crossbows faster
velocityModifier: 2
# How much additional base damage to apply to entities hit by crossbows
additionalDamage: 2
```

## Contributing

This assumes you are familiar with [Spigot Plugin Development](https://www.spigotmc.org/wiki/spigot-plugin-development/).

### Building

```
mvn package
```

The plugin jarfile is created at `./target/CrossbowRevamp-<version>-SNAPSHOT.jar`
