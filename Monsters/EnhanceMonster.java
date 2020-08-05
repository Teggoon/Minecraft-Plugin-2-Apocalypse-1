package me.Daniel.Apocalypse1Plugin.Monsters;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Daniel.Apocalypse1Plugin.Apocalypse1;
/**
 * Class handling the enhancement of spawned monsters
 * @author Haocheng Li/Daniel
 * @version 0.9.3
 * @since 2020-8-3
 * */
public class EnhanceMonster implements Listener {

	// variable used to connect back to main class
	private static Apocalypse1 plugin;
	
	// invisibility potion effect
	public static PotionEffect inviz = new PotionEffect(PotionEffectType.INVISIBILITY, 30000, 1, true, true);

	// mobs to spawn
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
	
	/**
	 * Constructor
	 * @param parent class object
	 * */
	public EnhanceMonster(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	/**
	 * Method that handles the enchancement of monsters
	 * @param the event of a creature spawning in the server
	 * */
	@EventHandler
	public void enhanceMonsters (CreatureSpawnEvent event) {
		
		// get the spawnefd entity's type
		EntityType enttype = event.getEntityType();

		// get the entity itself as object LivingEntity
		LivingEntity ent = event.getEntity();
		
		// get playerList
		List<Player> playerList = event.getEntity().getWorld().getPlayers();
		
		// This following chunk of code is just finding the closest player to the entity
		int minD = Integer.MAX_VALUE;
		int closest = -1;
		int mobY = (int) ent.getLocation().getY();
		int mobX = (int) ent.getLocation().getX();
		int mobZ = (int) ent.getLocation().getZ();
		for (int i = 0; i < playerList.size(); i++) {
			Location loc = playerList.get(i).getLocation();
			int xD = (int) loc.getX() - mobX;
			int yD = (int) loc.getY() - mobY;
			int zD = (int) loc.getZ() - mobZ;
			int D = xD * xD + yD * yD + zD * zD;
			if (D < minD) {
				minD = D;
				closest = i;
			}
		}
		
		// if there is a closest player and the entity isn't an enderman or an ender dragon, 
		// set the mob's target as the player
		if (closest != -1 && enttype != EntityType.ENDERMAN && enttype != EntityType.ENDER_DRAGON) {
			Mob samemob = (Mob) ent;
			samemob.setTarget(playerList.get(closest));
		}
		
		// following chunk of code is just enhancing different types of mobs
		if (enttype == EntityType.SPIDER) {
			setInvis(ent);
		}
		else if (enttype == EntityType.SKELETON || enttype == EntityType.STRAY ) 
		{
			// create enchanted bow to give to skeleton
			ItemStack bow5 = new ItemStack(Material.BOW);
			bow5.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
			bow5.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			
			// give skeleton bow
			ent.getEquipment().setItemInMainHand(bow5);
			SetMonsterLoot.setLoot(ent);
			setInvis(ent);
		} 
		else if (enttype == EntityType.ZOMBIE || enttype == EntityType.HUSK) 
		{ 

			
			// create enchanted sword for zombie
			ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			// give zombie sword.
			ent.getEquipment().setItemInMainHand(sword);
			SetMonsterLoot.setLoot(ent);
			setInvis(ent);
		} 
		else if (enttype == EntityType.CREEPER) 
		{
			int choice = (int) (Math.random() * MOB_CHOICES.length);
			if (closest != -1) {
				LivingEntity monster = (LivingEntity) ent.getWorld().spawnEntity(ent.getEyeLocation(), MOB_CHOICES[choice]);
				SetMonsterLoot.setLoot(monster);
			}
			
			// supercharge creeper
			Creeper c = (Creeper) event.getEntity();
			c.setPowered(true);
			setInvis(ent);
		} 
		else if (enttype == EntityType.DROWNED) 
		{
			ent.getEquipment().setItemInMainHand(new ItemStack(Material.TRIDENT));
			SetMonsterLoot.setLoot(ent);
		}
	}
	
	/**
	 * Helper method for setting a mob invisible
	 * */
	public void setInvis (LivingEntity ent) {
		ent.addPotionEffect(inviz);
	}
}
