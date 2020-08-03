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


public class DespawnMonsters implements Listener {
	
	private static Apocalypse1 plugin;
	
	public  static final int NUM_OF_MOBS_PER_WAVE = 5;
	
	public static final int SPAWN_RANGE_FROM_PLAYER = 20;
	
	public static final EntityType[] MOB_CHOICES = {
			EntityType.PHANTOM,
			EntityType.ZOMBIE,
			EntityType.HUSK,
			EntityType.SKELETON,
			EntityType.STRAY,
			EntityType.CREEPER,
			EntityType.CAVE_SPIDER,
			EntityType.BLAZE,
			EntityType.GHAST,
			EntityType.RAVAGER,
			};
	
	public DespawnMonsters(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	/**
	 * Helper method:
	 * 
	 * returns a spawn location for a monster based on a Player object
	 * */
	public Location spawnLocation(Player p, double x, double y, double z) {
		double angle = Math.random() * 3;
		double newx = x + Math.cos(angle) * (8 + Math.random() * SPAWN_RANGE_FROM_PLAYER);
		double newz = z + Math.sin(angle) * (8 + Math.random() * SPAWN_RANGE_FROM_PLAYER);
		return new Location(p.getWorld(), newx, y + 5, newz);
	}
	
	
	@EventHandler
	public void despawn(PlayerMoveEvent event) {
		

	}
	
}
