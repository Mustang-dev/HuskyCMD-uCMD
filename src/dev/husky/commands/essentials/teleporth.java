package dev.husky.commands.essentials;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.husky.devCMDMain;

public class teleporth implements CommandExecutor {
	
	public String ruta;
	private devCMDMain plugin;
	public teleporth(devCMDMain plugin) {
		this.plugin = plugin;
	}
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("huskycmd.teleport")) {
                return true;
            } else if (args.length < 1) {
                player.sendMessage((String.valueOf((new StringBuilder()).append(ChatColor.RED+"Correct Usage: /").append(label).append(" <player>"))));
                return true;
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    FileConfiguration config = plugin.getConfig();
                    String tpwr = "tp-wrong-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(tpwr) ));
                    return true;
                } else {
                    player.teleport(target.getLocation());
                    FileConfiguration config = plugin.getConfig();
                    String tpms = "tp-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(tpms) ));
                    return true;
                }
            }
        }
    }
}

