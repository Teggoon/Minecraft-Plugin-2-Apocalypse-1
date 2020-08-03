package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class GivePlayerGun implements Listener {

	private static Apocalypse1 plugin;
	
	public GivePlayerGun(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	//Give a player a crossbow the player respawns
	@EventHandler
	public void deathCheck(PlayerRespawnEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(event.getRespawnLocation(),new ItemStack(Material.CROSSBOW));
	}

	//Give a player a crossbow upno first joining
	@EventHandler
	public void joinCheck(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(p.getLocation(),new ItemStack(Material.CROSSBOW));
		
	}
}
