package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnvironmentSetup implements Listener{
	
	private static Apocalypse1 plugin;
	
	public EnvironmentSetup(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}

/*
	//Give a player blindness upon respawning
	@EventHandler
	public void respawnCheck(PlayerRespawnEvent event) {
		Player p = (Player) event.getPlayer();
		PotionEffect blind = new PotionEffect(PotionEffectType.BLINDNESS, 120000, 0, true);
		p.addPotionEffect(blind);
		
	}

	//Give a player blindness upon joining
	@EventHandler
	public void joinCheck(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();
		PotionEffect blind = new PotionEffect(PotionEffectType.BLINDNESS, 120000, 0, true);
		p.addPotionEffect(blind);
	}
	*/

	// handle environment stuff
	@EventHandler
	public void environment(PlayerMoveEvent event) {
		Player p = (Player) event.getPlayer();
		World w = p.getWorld();
		w.setTime(15000);
		w.setStorm(false);

		// strike lightning
		double setNum = Math.random();
		if (setNum < 0.1) {
			double angle = Math.random() * 3;
			double newx = p.getLocation().getX() + Math.cos(angle) * (8 + Math.random() * 20);
			double newz = p.getLocation().getZ() + Math.sin(angle) * (8 + Math.random() * 20);
			w.strikeLightning(new Location(w, newx, p.getLocation().getY(), newz));
		}
		
		if (setNum < 0.05) {
			w.setThunderDuration(20);
			w.playSound(p.getLocation(), Sound.AMBIENT_NETHER_WASTES_LOOP, 12, 1);
		}
	}
}
