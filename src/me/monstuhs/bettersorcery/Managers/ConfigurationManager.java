/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bettersorcery.Managers;

import me.monstuhs.bettersorcery.Utilities.ConfigConstants;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class ConfigurationManager {

    private static JavaPlugin _plugin;
    private static FileConfiguration _configFile;

    /**
     * @return the _configFile
     */
    public FileConfiguration getConfigFile() {
        return _configFile;
    }

    public ConfigurationManager(JavaPlugin thisPlugin) {
        _plugin = thisPlugin;
        _configFile = _plugin.getConfig();
        createOrLoadConfig();
    }

    private void createOrLoadConfig() {
        _configFile.options().copyDefaults(true);

        _configFile.addDefault(ConfigConstants.GlobalSettings.WORLD_NAME, _plugin.getServer().getWorlds().get(0).getName());        

        _configFile.addDefault(ConfigConstants.GlobalSettings.SETTINGS_WORLD_ORE_IRON_FREQUENCY_PERCENTAGE, 75);

        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESTRUCTION_MANA_MATERIAL, Material.REDSTONE_ORE.toString());
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESTRUCTION_WAND, Material.BLAZE_ROD.toString());
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESTRUCTION_SPELLS_FIREBALL_MANACOST, 1);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESTRUCTION_SPELLS_KNOCKBACK_MANACOST, 1);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESTRUCTION_SPELLS_KNOCKBACK_RANGE_PER_LEVEL, 3);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESCTURCTION_SPELLS_LIGHTING_MANACOST, 1);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESCTURCTION_SPELLS_LIGHTING_RANGE, 50);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_DESCTURCTION_SPELLS_PIT_MANACOST, 1);

        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_HEALING_MANA_MATERIAL, Material.REDSTONE_ORE.toString());
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_HEALING_WAND, Material.BLAZE_ROD.toString());
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_HEALING_SPELLS_HEAL_MANACOST, 1);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_HEALING_SPELLS_HEAL_RANGE, 50);
        _configFile.addDefault(ConfigConstants.Sorcery.SORCERY_ALLOW_MANA_BURN, Boolean.TRUE);
        
        _plugin.saveConfig();
    }
}
