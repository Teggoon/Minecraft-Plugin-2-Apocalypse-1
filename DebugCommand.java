package me.Daniel.Apocalypse1Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that helps do the basic debug commands
 * @author Haocheng Li / Daniel
 * @version 0.9.3	
 * @since 2020-8-3 
 * */
public class DebugCommand implements CommandExecutor {

	// variable used to connect back to the main class with
	private static Apocalypse1 plugin;
	
	/**
	 * Constructor
	 * @param parent class object
	 * */
	public DebugCommand(Apocalypse1 plugin) {
		this.plugin = plugin;
		
		// connect "hello" to this class
		plugin.getCommand("hello").setExecutor(this);
		
		// connect "ec" to this class
		plugin.getCommand("ec").setExecutor(this);
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
		// check if command is ec
		if (label.equalsIgnoreCase("ec")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				// print the count of entities in the world
				Player p = (Player) sender;
				p.sendMessage("Entities in the world: " + p.getWorld().getEntities().size());
				
				return true;
			} 
		}
		
		return false;
	}
}
