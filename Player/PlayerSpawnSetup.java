package me.Daniel.Apocalypse1Plugin.Player;

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

import me.Daniel.Apocalypse1Plugin.Apocalypse1;
/**
 * Class that sets up the player upon spawning or joining the server
 * @author Haocheng Li / Daniel
 * @version 0.9.3	
 * @since 2020-8-3 
 * */
public class PlayerSpawnSetup implements Listener {

	// variable used to connect back to main class
	private static Apocalypse1 plugin;

	/**
	 * Constructor
	 * @param parent class object
	 * */
	public PlayerSpawnSetup(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	/**Give a player a crossbow and a health boost when the player respawns
	 * @param Player respawning event
	 * */
	@EventHandler
	public void deathCheck(PlayerRespawnEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(event.getRespawnLocation(), new ItemStack(Material.CROSSBOW));
		
		PotionEffect regen = new PotionEffect(PotionEffectType.HEALTH_BOOST, 300, 2);
		p.addPotionEffect(regen);
	}
	
	/**Give a player a crossbow and a health boost when the player respawns
	 * @param Player joining event
	 * */
	@EventHandler
	public void joinCheck(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();
		p.getWorld().dropItemNaturally(p.getLocation(),new ItemStack(Material.CROSSBOW));
		
		PotionEffect regen = new PotionEffect(PotionEffectType.HEALTH_BOOST, 300, 2);
		p.addPotionEffect(regen);
		
	}
}
