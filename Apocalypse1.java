package me.Daniel.Apocalypse1Plugin;

import org.bukkit.plugin.java.JavaPlugin;


public class Apocalypse1 extends JavaPlugin {

	@Override
	public void onEnable() {
		// runs on startups, reloads, plugin reloads

		// Crossbow Gun elements
		new RemoveBullet(this);
		new FireBullet(this);
		new HelloCommand(this);
		new SpawnMonsters(this);
		new GivePlayerGun(this);
	}
}
