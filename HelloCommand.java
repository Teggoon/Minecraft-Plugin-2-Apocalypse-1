package me.Daniel.Apocalypse1Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class HelloCommand implements CommandExecutor {

	private static Apocalypse1 plugin;
	
	public HelloCommand(Apocalypse1 plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// check if command is hello
		if (label.equalsIgnoreCase("hello")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				//
				Player p = (Player) sender;
				p.sendMessage("Hello there!");
				
				return true;
			} 
		}
		
		return false;
	}
}
