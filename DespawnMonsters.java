package me.Daniel.Apocalypse1Plugin;

import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class that handles despawning monsters for lag.
 * Does not work as of 2020-8-3
 * */
public class DespawnMonsters implements Listener {
	
	// Variable to connect back to main class with
	private static Apocalypse1 plugin;
	
	/**
	 * Constructor
	 * @param parent class object
	 * */
	public DespawnMonsters(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	
	@EventHandler
	public void despawn(PlayerMoveEvent event) {
		

	}
	
}
