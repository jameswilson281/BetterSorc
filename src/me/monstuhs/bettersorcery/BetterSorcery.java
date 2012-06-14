/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bettersorcery;

import me.monstuhs.bettersorcery.EventHandlers.SpellCastListener;
import me.monstuhs.bettersorcery.Managers.ConfigurationManager;
import me.monstuhs.bettersorcery.Managers.SpellManager;
import me.monstuhs.bettersorcery.Utilities.ConfigConstants;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class BetterSorcery extends JavaPlugin {

    private ConfigurationManager _configManager;    
    private PluginManager _pluginManager = Bukkit.getPluginManager();
    
    
    public static SpellManager SpellManager;
    
    @Override
    public void onEnable() {
        _configManager       = new ConfigurationManager(this);
        SpellManager         = new SpellManager(_configManager.getConfigFile());
    
        _pluginManager.registerEvents(new SpellCastListener(), this);

        registerCommands();
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelAllTasks();
    }

    public void saveConfigurationFile() {
        saveConfig();
    }

    private void registerCommands() {
        //NOTHING
    }
}
