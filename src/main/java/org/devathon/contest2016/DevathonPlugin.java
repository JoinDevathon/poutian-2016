package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        startup();
    }

    @Override
    public void onDisable() {

    }

    private void startup() {
        Bukkit.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockInteractListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        this.getCommand("deconstruct").setExecutor(new DeconstructCommand(this));
    }
}

