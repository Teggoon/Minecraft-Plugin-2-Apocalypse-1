package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class RemoveBullet implements Listener{
	
	private static Apocalypse1 plugin;
	
	public RemoveBullet(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}

	@EventHandler
	public void collisionCheck(ProjectileHitEvent event) {
		Projectile proj = event.getEntity();
		if (proj.getShooter() instanceof Player && proj instanceof Arrow ) {
			Arrow arr = (Arrow) proj; 
			if (arr.isShotFromCrossbow()) {
				proj.remove();
			}
		}
	}
	
}
