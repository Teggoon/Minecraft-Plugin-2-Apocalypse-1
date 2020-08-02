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


public class SpawnMonsters implements Listener {
	
	private static Apocalypse1 plugin;
	
	public  static final int NUM_OF_MOBS_PER_WAVE = 5;
	
	public static EntityType[] MOB_CHOICES = {
			EntityType.PHANTOM,
			EntityType.ZOMBIE,
			EntityType.HUSK,
			EntityType.SKELETON,
			EntityType.STRAY,
			EntityType.ENDER_DRAGON,
			EntityType.CREEPER,
			EntityType.CAVE_SPIDER,
			EntityType.BLAZE,
			EntityType.GHAST,
			EntityType.ELDER_GUARDIAN,
			EntityType.RAVAGER,
			EntityType.EVOKER,
			};
	
	public SpawnMonsters(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	/**
	 * Helper method:
	 * 
	 * returns a spawn location for a monster based on a Player object
	 * */
	public Location spawnLocation(Player p, double x, double y, double z) {
		double angle = Math.random();
		double newx = x + Math.cos(angle) * (8 + Math.random() * 20);
		double newz = z + Math.sin(angle) * (8 + Math.random() * 20);
		return new Location(p.getWorld(), newx, y + 5, newz);
	}
	
	@EventHandler
	public void enhanceMonsters (CreatureSpawnEvent event) {
		EntityType enttype = event.getEntityType();
		
		LivingEntity mob = event.getEntity();
		PotionEffect inviz = new PotionEffect(PotionEffectType.INVISIBILITY, 30000, 1, true);
		mob.addPotionEffect(inviz);
		
		/*
		List<Player> playerList = event.getEntity().getWorld().getPlayers();
		int minD = Integer.MAX_VALUE;
		int closest = -1;
		int mobY = (int) Math.floor(mob.getLocation().getY());
		int mobX = (int) Math.floor(mob.getLocation().getX());
		int mobZ = (int) Math.floor(mob.getLocation().getZ());
		for (int i = 0; i < playerList.size(); i++) {
			Location loc = playerList.get(i).getLocation();
			int xD = (int) Math.floor(loc.getX()) - mobX;
			int yD = (int) Math.floor(loc.getY()) - mobY;
			int zD = (int) Math.floor(loc.getZ()) - mobZ;
			int D = xD * xD + yD * yD + zD * zD;
			if (D < minD) {
				minD = D;
				closest = i;
			}
		}
		if (closest != -1 && enttype != EntityType.ENDERMAN) {
			Mob samemob = (Mob) mob;
			samemob.setTarget(playerList.get(closest));
		}
		if (closest != -1 && Math.abs(playerList.get(closest).getLocation().getY() - mobY) > 26) {
			//mob.remove();
		}
		*/
		
		
		if (enttype == EntityType.SKELETON || enttype == EntityType.STRAY ) 
		{
			LivingEntity s = event.getEntity();
			// create enchanted bow to give to skeleton
			ItemStack bow5 = new ItemStack(Material.BOW);
			bow5.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
			bow5.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			
			// give skeleton bow
			s.getEquipment().setItemInMainHand(bow5);
		} 
		else if (enttype == EntityType.ZOMBIE || enttype == EntityType.HUSK) 
		{ 

			LivingEntity z = event.getEntity();
			
			// create enchanted sword for zombie
			ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			// give zombie swor.
			z.getEquipment().setItemInMainHand(sword);
		} 
		else if (enttype == EntityType.CREEPER) 
		{
			
			// supercharge creeper
			Creeper c = (Creeper) event.getEntity();
			c.setPowered(true);
		} 
		else if (enttype == EntityType.DROWNED) 
		{
			LivingEntity dr = event.getEntity();
			dr.getEquipment().setItemInMainHand(new ItemStack(Material.TRIDENT));
		}
	}
	
	@EventHandler
	public void spawnMonsters(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		World w = p.getWorld();
		w.setTime(15000);
		double x = p.getLocation().getX();
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ();
		
		if (w.getEntities().size() > 100) {
			//w.getEntities().get(0).remove();
		}
		
		// spawning a wave of monsters
		double setNum = Math.random();
		if (p.getWorld().getEntities().size() < 150 && setNum < 0.1) {
			System.out.println("spawning wave: ");
			for (int i = 0; i < NUM_OF_MOBS_PER_WAVE; i++) {
				int choice = (int) Math.floor(Math.random() * MOB_CHOICES.length);
				System.out.println(MOB_CHOICES[choice] + "is being spawned.");
				p.getWorld().spawnEntity(spawnLocation(p, x, y, z), MOB_CHOICES[choice]);
			}
		}

	}
}
