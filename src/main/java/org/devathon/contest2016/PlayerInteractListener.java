package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class PlayerInteractListener implements Listener {

    Plugin plugin;
    String machineblk;
    public PlayerInteractListener(Plugin pl) {
        plugin = pl;
        machineblk = plugin.getConfig().getString("machine");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getClickedBlock().getType().toString().equalsIgnoreCase(machineblk) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Inventory deconInv = Bukkit.createInventory(null, 9, "Deconstruction");
            Player p = event.getPlayer();
            p.openInventory(deconInv);
            event.setCancelled(true);
        }
    }
}
