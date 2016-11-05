package org.devathon.contest2016;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Iterator;
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

                    if(deconItems.contains(is.getType().toString().toLowerCase())) {
                        Set<String> itemsToGive = plugin.getConfig().getConfigurationSection("deconstruct." + is.getType().toString().toLowerCase()).getKeys(false);
                        for(Iterator<String> it = itemsToGive.iterator(); it.hasNext();) {
                            String label = it.next();
                            Material mat = Material.getMaterial(label.toUpperCase());
                            int amount = plugin.getConfig().getInt("deconstruct." + is.getType().toString().toLowerCase() + "." + label);

                            addToInv(new ItemStack(mat, amount * is.getAmount()), p);
                            p.sendMessage(ChatColor.GREEN + "Salvaged " + is.getAmount() + " " + is.getType().toString() + " to get " + amount * is.getAmount() + " " + mat.toString());
                        }
                    } else {
                        addToInv(is, p);
                        p.sendMessage(ChatColor.RED + "You can not salvage " + is.getType().toString());
                    }
                }

            }
        }
    }

    private void addToInv(ItemStack is, Player p) {
        Inventory inv = p.getInventory();
        boolean full = true;
        for(int i = 0; i < 36; i++) {
            if(inv.getItem(i) == null) {
                full = false;
            }
        }

        if(!full) {
            inv.addItem(is);
        } else {
            p.sendMessage(ChatColor.RED + "Your inventory is full, dropping items on ground");
            p.getWorld().dropItem(p.getLocation(), is);
        }
    }
}
