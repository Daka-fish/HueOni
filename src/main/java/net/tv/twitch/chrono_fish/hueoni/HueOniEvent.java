package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HueOniEvent implements Listener {

    @EventHandler
    public void onTouch(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){

        }
    }
}
