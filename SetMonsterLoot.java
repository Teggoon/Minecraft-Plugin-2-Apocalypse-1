package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class SetMonsterLoot {
	
	public static final float DROP_CHANCE = (float) 1;
	
	public static final int DROP_NUM_RANGE = 3;

	public static final Material[] loots = {
		Material.JUNGLE_LOG,
		Material.IRON_INGOT,
		Material.COOKED_BEEF,
		Material.COAL
	};
	
	public static void setLoot(LivingEntity monster) {
		int choice = (int) Math.floor(Math.random() * loots.length);
		ItemStack loot = new ItemStack(loots[choice], (int) (Math.random() * DROP_NUM_RANGE));
		monster.getEquipment().setItemInOffHand(loot);
		monster.getEquipment().setItemInOffHandDropChance(DROP_CHANCE);
	}
	
}
