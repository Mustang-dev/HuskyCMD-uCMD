package dev.husky.commands.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.husky.devCMDMain;
import net.md_5.bungee.api.ChatColor;

public class TeleportHereCommand implements CommandExecutor {
	
	public String ruta;
	private devCMDMain plugin;
	public TeleportHereCommand(devCMDMain plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("huskycmd.teleporthere")) {
                return true;
            } else if (args.length < 1) {
                player.sendMessage((String.valueOf((new StringBuilder()).append(ChatColor.RED+"Correct Usage: /").append(label).append(" <player>"))));
                return true;
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    return true;
                } else {
                    target.teleport(player.getLocation());
                    FileConfiguration config = plugin.getConfig();
                    String tpss = "tp-s-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(tpss) ));
                    return true;
                }
            }
        }
    
	}
}