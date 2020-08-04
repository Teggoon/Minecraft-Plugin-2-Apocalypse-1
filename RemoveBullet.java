package me.Daniel.Apocalypse1Plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

/**
 * Class that handles the removal of a bullet when the bullet collides with something
 * */
public class RemoveBullet implements Listener{
	
	private static Apocalypse1 plugin;
	
	/**
	 * Constructor
	 * @param parent class object
	 * */
	public RemoveBullet(Apocalypse1 plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}

	/**
	 * Method that checks for collision and removes the bullet
	 * @param event of a projectile hitting something
	 * */
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
