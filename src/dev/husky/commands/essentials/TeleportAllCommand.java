package dev.husky.commands.essentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.husky.devCMDMain;

public class TeleportAllCommand implements CommandExecutor {
	public String ruta;
	private devCMDMain plugin;
	
	public TeleportAllCommand(devCMDMain plugin) {
		this.plugin = plugin;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("huskycmd.teleportall")) {
                return true;
            } else {
                Bukkit.getServer().getOnlinePlayers().forEach((p) -> {
                    p.teleport(player.getLocation());
                    
                    FileConfiguration config = plugin.getConfig();
                    String tpalls = "tp-all-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(tpalls) ));
                });
                return true;
            }
        }
    }
    }

