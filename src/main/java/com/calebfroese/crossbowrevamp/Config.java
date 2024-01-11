package com.calebfroese.crossbowrevamp;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private FileConfiguration config;

    private enum PROPERTY {
        velocityModifier,
        additionalDamage,
    }

    /**
     * Reloads the config from disk, adding any missing configuration
     */
    public void load() {
        config = CrossbowRevampPlugin.instance.getConfig();

        config.addDefault(PROPERTY.velocityModifier.name(), 2);
        config.addDefault(PROPERTY.additionalDamage.name(), 2);

        config.options().copyDefaults(true);

        CrossbowRevampPlugin.instance.saveConfig();
    }

    /**
     * How much to multiple crossbow projectiles velocity by
     * 
     * @return An integer representing the velocity modifier
     */
    public int getVelocityModifier() {
        return config.getInt(PROPERTY.velocityModifier.name());
    }

    /**
     * How much additional base damage to apply to entities hit by crossbows
     * 
     * @return An integer representing additional damage applied
     */
    public int getAdditionalDamage() {
        return config.getInt(PROPERTY.additionalDamage.name());
    }
}
