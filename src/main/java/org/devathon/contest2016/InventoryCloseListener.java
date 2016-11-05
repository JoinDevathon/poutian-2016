package org.devathon.contest2016;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Set;

public class InventoryCloseListener implements Listener {

    Plugin plugin;
    Set<String> deconItems;

    public InventoryCloseListener(Plugin pl) {
        plugin = pl;
        deconItems = plugin.getConfig().getConfigurationSection("deconstruct").getKeys(false);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inv = event.getInventory();

        if(inv.getName().equalsIgnoreCase("Deconstruction")) {
            Player p = (Player) event.getPlayer();
            ArrayList<ItemStack> items = new ArrayList<ItemStack>();

            for(int i = 0; i < 9; i++) {
                if(inv.getItem(i) != null) {
                    ItemStack is = inv.getItem(i);
                    p.sendMessage(is.getType().toString());

                    if(deconItems.contains(is.getType().toString().toLowerCase())) {
                        p.sendMessage("Contains " + is.getType().toString());
                    }
                }

            }
        }
    }
}
