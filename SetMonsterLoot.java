package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

/***
 * Helper class that sets each hostile monster's loot
 * @author Haocheng Li / Daniel
 * @version 0.9.4	
 * @since 2020-8-3 
 */
public class SetMonsterLoot {
	
	// drop chance of loot
	public static final float DROP_CHANCE = (float) 1;
	
	// amount of loot that could drop
	public static final int DROP_NUM_RANGE = 3;

	// kinds of loot that will drop
	public static final Material[] loots = {
		Material.JUNGLE_LOG,
		Material.IRON_INGOT,
		Material.COOKED_BEEF,
		Material.COAL,
		Material.DIAMOND
	};
	
	/**
	 * Method that sets the loot of an entity
	 * @param a LivingEntity object
	 * */
	public static void setLoot(LivingEntity monster) {
		int choice = (int) Math.floor(Math.random() * loots.length);
		ItemStack loot = new ItemStack(loots[choice], (int) (Math.random() * DROP_NUM_RANGE));
		monster.getEquipment().setItemInOffHand(loot);
		monster.getEquipment().setItemInOffHandDropChance(DROP_CHANCE);
	}
	
}
