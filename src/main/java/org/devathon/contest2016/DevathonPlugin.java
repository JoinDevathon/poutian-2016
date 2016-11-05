package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class DevathonPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        File config = new File(getDataFolder(), "config.yml");

        if(!config.exists()) {
            saveDefaultConfig();
        }
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

