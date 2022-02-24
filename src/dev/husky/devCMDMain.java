package dev.husky;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import dev.husky.commands.discordcommand;
import dev.husky.commands.huskycc;
import dev.husky.commands.storecommand;
import dev.husky.commands.teamspeakcommand;
import dev.husky.commands.webcommand;
import dev.husky.commands.essentials.TeleportAllCommand;
import dev.husky.commands.essentials.TeleportHereCommand;
import dev.husky.commands.essentials.fly;
import dev.husky.commands.essentials.gmccommand;
import dev.husky.commands.essentials.teleporth;

public class devCMDMain extends JavaPlugin{
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String nombre = pdffile.getName();
	public String ruta;
	public FileConfiguration license = null;
	public File licenseFile = null;
	
	public void onEnable() {
		ConsoleCommandSender c = Bukkit.getConsoleSender();
		c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7--------------------------------------------------------------"));
		c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aLoading All Data..."));
		c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7--------------------------------------------------------------"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &aHusky&cCMD &7 | &fCore                       "));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &aHusky&cCMD &fPlugin is Now &aSuccesfuly &aEnable!"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &cLicense: &fThis Plugin is Free"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &cVersion: &b"+version));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &cAuthor: &bPyc Paint AlX"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &aHusky&cCMD &bThanks For Use"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &6Powered: &fHuskyDevelopment"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7----------------------------------------------------------------------"));
        registercommands();
        registerConfig();
	}
	
	public void onDisable() {
        ConsoleCommandSender c = Bukkit.getConsoleSender();
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7--------------------------------------------------------------"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "          &aHusky&cCMD &7 | &fCore                       "));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &aHusky&cCMD Plugin is Now &aSuccesfuly &cDisable!"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &cVersion: &b"+version));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &cAuthor: &bPyc Paint AlX"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[&aHusky&cCMD&b] &aHusky&cCMD &bThanks For Use"));
        c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7----------------------------------------------------------------------"));
    }
	
    private void registercommands() {
    	this.getCommand("discord").setExecutor(new discordcommand(this));
    	this.getCommand("huskycmd").setExecutor(new huskycc(this));
    	this.getCommand("store").setExecutor(new storecommand(this));
    	this.getCommand("teamspeak").setExecutor(new teamspeakcommand(this));
    	this.getCommand("website").setExecutor(new webcommand(this));
    	this.getCommand("teleportall").setExecutor(new TeleportAllCommand(this));
    	this.getCommand("teleporth").setExecutor(new teleporth(this));
    	this.getCommand("fly").setExecutor(new fly(this));
    	this.getCommand("gamemode").setExecutor(new gmccommand(this));
    	this.getCommand("teleporthere").setExecutor(new TeleportHereCommand(this));
    
	}

public void registerConfig() {
	
	File config = new File(this.getDataFolder(),"config.yml");
	ruta = config.getPath();
	
	if(!config.exists()) {
	this.getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	}
}
}