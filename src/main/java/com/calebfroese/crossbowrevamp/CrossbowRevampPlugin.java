package com.calebfroese.crossbowrevamp;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CrossbowRevampPlugin extends JavaPlugin implements Listener {

  public static CrossbowRevampPlugin instance;

  private Config config;

  @Override
  public void onEnable() {
    instance = this;

    this.config = new Config();
    this.config.load();

    getServer().getPluginManager().registerEvents(new ProjectileEventHandler(), this);
  }

  public Config getPluginConfiguration() {
    return this.config;
  }
}
