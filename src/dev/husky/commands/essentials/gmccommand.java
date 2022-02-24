package dev.husky.commands.essentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.husky.devCMDMain;
import net.md_5.bungee.api.ChatColor;

public class gmccommand implements CommandExecutor {
	public String ruta;
	private devCMDMain plugin;
	
	public gmccommand(devCMDMain plugin) {
		this.plugin = plugin;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("huskycmd.gamemode")) {
                return true;
            } else if (args.length < 1) {
                player.sendMessage((String.valueOf((new StringBuilder()).append(ChatColor.RED+"Correct Usage: /").append(label).append(" <mode>"))));
                return true;
            } else {
                if (!args[0].equalsIgnoreCase("0") && !args[0].equalsIgnoreCase("survival")) {
                    if (!args[0].equalsIgnoreCase("1") && !args[0].equalsIgnoreCase("creative")) {
                        if (!args[0].equalsIgnoreCase("2") && !args[0].equalsIgnoreCase("adventure")) {
                            player.sendMessage((String.valueOf((new StringBuilder()).append(ChatColor.RED+"Argument '").append(args[0]).append("' Not Found."))));
                            return true;
                        }

                        if (player.getGameMode() == GameMode.ADVENTURE) {
                        	FileConfiguration config = plugin.getConfig();
                            String gmam = "gamemode-a-msg";
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(gmam) ));
                            return true;
                        }

                        player.setGameMode(GameMode.ADVENTURE);
                    
                    } else {
                       
                    	if (player.getGameMode() == GameMode.CREATIVE) {
                        	FileConfiguration config = plugin.getConfig();
                            String gmcm = "gamemode-c-msg";
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(gmcm) ));
                            
                            return true;
                        }

                        player.setGameMode(GameMode.CREATIVE);
                    }
                } else {
                    if (player.getGameMode() == GameMode.SURVIVAL) {
                    	FileConfiguration config = plugin.getConfig();
                        String gmsm = "gamemode-s-msg";
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(gmsm) ));
                        
                        return true;
                    }

                    player.setGameMode(GameMode.SURVIVAL);
                }
                return true;
            }
        }
    }
}
