package net.tv.twitch.chrono_fish.taggame.Listener;

import net.tv.twitch.chrono_fish.taggame.Instance.PlayerState;
import net.tv.twitch.chrono_fish.taggame.Manager.StateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        StateManager.setState(e.getPlayer(),PlayerState.Runner);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){if(!e.getPlayer().isOp()){e.getPlayer().getInventory().clear();}}
}
