package net.tv.twitch.chrono_fish.taggame.Listener;

import net.tv.twitch.chrono_fish.taggame.Instance.PlayerState;
import net.tv.twitch.chrono_fish.taggame.Manager.StateManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GameListener implements Listener {

    @EventHandler
    public void onTouch(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            Player damager = (Player) e.getDamager();
            Player player = (Player) e.getEntity();
            if(damager.getInventory().getItemInMainHand().getType().equals(Material.STICK)){
                if(StateManager.getState(player).equals(PlayerState.Runner)){
                    StateManager.setState(player,PlayerState.Oni);
                }
            }
        }
    }
}
