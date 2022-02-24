package dev.husky.commands.essentials;

import java.util.ArrayList;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPluginLoader;

import dev.husky.devCMDMain;

public class fly implements CommandExecutor {
	public String ruta;
	private devCMDMain plugin;
	
	public fly(devCMDMain plugin) {
		this.plugin = plugin;
	}

    public static List<Player> fly = new ArrayList();
    

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("huskycmd.fly")) {
                return true;
            } else {
                if (fly.contains(player)) {
                    fly.remove(player);
                    player.setAllowFlight(false);
                    FileConfiguration config = plugin.getConfig();
                    String flyd = "fly-disable-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(flyd) ));
                } else {
                    fly.add(player);
                    player.setAllowFlight(true);
                    FileConfiguration config = plugin.getConfig();
                    String flyy = "fly-enable-msg";
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(flyy) ));
                }

                return true;
            }
        }
    }
}
