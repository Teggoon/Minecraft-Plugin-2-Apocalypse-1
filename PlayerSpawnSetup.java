package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerSpawnSetup implements Listener {

	private static Apocalypse1 plugin;

	
	public PlayerSpawnSetup(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	//Give a player a crossbow the player respawns
	@EventHandler
	public void deathCheck(PlayerRespawnEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(event.getRespawnLocation(), new ItemStack(Material.CROSSBOW));
		PotionEffect regen = new PotionEffect(PotionEffectType.HEALTH_BOOST, 300, 2);
		p.addPotionEffect(regen);
	}

	//Give a player a crossbow upno first joining
	@EventHandler
	public void joinCheck(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(p.getLocation(),new ItemStack(Material.CROSSBOW));
		PotionEffect regen = new PotionEffect(PotionEffectType.HEALTH_BOOST, 300, 2);
		p.addPotionEffect(regen);
		
	}
}
