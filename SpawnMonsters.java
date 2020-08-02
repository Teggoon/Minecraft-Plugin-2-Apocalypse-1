package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnMonsters implements Listener {
	
	private static Apocalypse1 plugin;
	
	public SpawnMonsters(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	@EventHandler
	public void spawnMonsters(CreatureSpawnEvent event) {
		EntityType enttype = event.getEntityType();
		
		if (enttype == EntityType.SKELETON) {
			LivingEntity s = event.getEntity();
			
			s.getWorld().spawnEntity(s.getLocation(),EntityType.PHANTOM);
			
			ItemStack bow5 = new ItemStack(Material.BOW);
			bow5.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
			bow5.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			
			s.getEquipment().setItemInMainHand(bow5);
			
		} else if (enttype == EntityType.ZOMBIE) {
			LivingEntity z = event.getEntity();
			z.damage(5);
			z.getWorld().spawnEntity(z.getLocation(),EntityType.VINDICATOR);
		} else if (enttype == EntityType.SPIDER) {
			LivingEntity s = event.getEntity();
			s.damage(5);
			s.getWorld().spawnEntity(s.getLocation(),EntityType.CAVE_SPIDER);
			
		}
	}
}
