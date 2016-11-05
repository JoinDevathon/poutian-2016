package org.devathon.contest2016;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DeconstructCommand implements CommandExecutor {

    Plugin pl;
    public DeconstructCommand(Plugin plugin) {
        pl = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final String helpMessage = ChatColor.AQUA + "Deconstruction commands: \n/Deconstruct reloadConfig: Grabs values from the config file without needing to restart the server";
        if(args.length == 0) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(helpMessage);
                return true;
            } else {
                System.out.println(helpMessage);
                return true;
            }
        }
        return false;
    }
}
