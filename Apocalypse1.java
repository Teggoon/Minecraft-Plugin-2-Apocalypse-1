package me.Daniel.Apocalypse1Plugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.Daniel.Apocalypse1Plugin.Environment.EnvironmentSetup;
import me.Daniel.Apocalypse1Plugin.Monsters.DespawnMonsters;
import me.Daniel.Apocalypse1Plugin.Monsters.EnhanceMonster;
import me.Daniel.Apocalypse1Plugin.Player.FireBullet;
import me.Daniel.Apocalypse1Plugin.Player.PlayerSpawnSetup;
import me.Daniel.Apocalypse1Plugin.Player.RemoveBullet;

/**
 * Parent class that extends Java Plugin and brings all the different classes' functionalities together
 * @author Haocheng Li / Daniel
 * @version 0.9.3	
 * @since 2020-8-3 
 * 
 * */
public class Apocalypse1 extends JavaPlugin {

	@Override
	public void onEnable() {
		// runs on startups, reloads, plugin reloads

		// Connect different event handlers to the parent class
		
		// Connecting debug command
		new DebugCommand(this);
		
		// Connecting player and environment setup
		new PlayerSpawnSetup(this);
		new EnvironmentSetup(this);
		
		// Crossbow gun connecting
		new RemoveBullet(this);
		new FireBullet(this);
		
		// Monster spawning and enhancing mechanism connecting
		new DespawnMonsters(this);
		new EnhanceMonster(this);
	}
}
