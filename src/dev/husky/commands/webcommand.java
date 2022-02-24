package dev.husky.commands;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import dev.husky.devCMDMain;


public class webcommand implements CommandExecutor {
	public String ruta;
	private devCMDMain plugin;
	
	public webcommand(devCMDMain plugin) {
		this.plugin = plugin;
}

	@Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&fHusky&aCMD&7] &cYou have a Problem &7 You Can't Execute commands in Console"));
            return false;
        }else {
        	Player jugador = (Player) commandSender;
            FileConfiguration config = plugin.getConfig();
            String wbs = "website-msg";
            jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(wbs) ));
                    return true;
        }
	}
}
