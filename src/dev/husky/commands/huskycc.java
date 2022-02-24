package dev.husky.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.husky.devCMDMain;

import org.bukkit.ChatColor;

public class huskycc implements CommandExecutor {
    private devCMDMain main;
    public huskycc(devCMDMain main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Player j = (Player) sender;
            String spacing = ChatColor.translateAlternateColorCodes('&', "&f");

            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &f&lHusky&a&lCMD &7&lCore"));
            j.sendMessage(spacing);
            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &cDevelopment by&7: &6Pyc Paint AlX#7967, Maza Dev#3680"));
            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &cPowered by&7: &6Husky Development"));
            j.sendMessage(spacing);
            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f Please use /huskycmd help for list of commands"));
            j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
            return false;
        }else {
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")) {
                    Player j = (Player) sender;
                    main.reloadConfig();
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&fHusky&aCMD&8] &aAll config has been reloaded"));
                    return true;
                }
                else if(args[0].equalsIgnoreCase("version")) {
                    Player j = (Player) sender;
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &cVersion&7: &f1.0"));
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
                    return true;
                }
                else if(args[0].equalsIgnoreCase("help")) {
                    Player j = (Player) sender;
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse /huskycmd (plugins, reload)"));
                    return true;
                }
                else {
                    Player j = (Player) sender;
                    j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&fHusky&aCMD&8] &cUknown Command, Please use /huskycmd help"));
                    return true;
                }
            }else {
                Player j = (Player) sender;

                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &f&lHusky&a&lCMD &7&lCore"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &cDevelopment by&7: &6Pyc Paint AlX#7967, Maza Dev#3680"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &cPowered by&7: &6Husky Development"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f Please use /huskycmd help for list of commands"));
                j.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m+--------------------------------+"));
                return true;
            }
        }
    }
}