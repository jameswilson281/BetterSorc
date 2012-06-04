/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bettersorcery.EventHandlers;

import me.monstuhs.bettersorcery.BetterSorcery;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author James
 */
public class SpellCastListener implements Listener {

   
    @EventHandler(priority = EventPriority.NORMAL)
    public void onCastSpell(PlayerInteractEvent event) {
        if (event.getMaterial() == Material.BLAZE_ROD && event.getAction() == Action.LEFT_CLICK_AIR) {
            BetterSorcery.SpellManager.useWand(event.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onChangeActiveSpell(PlayerInteractEvent event) {
        if (event.getMaterial() == Material.BLAZE_ROD && event.getAction() == Action.RIGHT_CLICK_AIR) {
            BetterSorcery.SpellManager.cycleSpellsForPlayer(event.getPlayer().getName());
        }
    }
}
