package org.devathon.contest2016;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.AQUA + "Hey judges, the default config uses an iron block to deconstruct things.");
        event.getPlayer().sendMessage(ChatColor.AQUA + "The default config also specifies that dirt and gravel can be deconstructed.");
        event.getPlayer().sendMessage(ChatColor.AQUA + "You can edit all values in the config. :)");
    }
}
