package net.tv.twitch.chrono_fish.taggame.Manager;

import net.tv.twitch.chrono_fish.taggame.Instance.PlayerState;
import net.tv.twitch.chrono_fish.taggame.Item.StateItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class StateManager {

    private static HashMap<UUID, PlayerState> StateMap;

    public StateManager() {StateMap = new HashMap<>();}

    public static void setState(Player player,PlayerState state){
        StateMap.put(player.getUniqueId(),state);
        switch(state){
            case Oni:
                StateItem.oniItem(player);
                break;
            case Runner:
                StateItem.runnerItem(player);
                break;
            default:
                break;
        }
    }

    public static HashMap<UUID, PlayerState> getStateMap() { return StateMap; }

    public static PlayerState getState(Player player){
        return StateMap.get(player.getUniqueId());
    }

    public static int getRunner(){
        int runner = 0;
        for(Player player: Bukkit.getOnlinePlayers()){
            if(getState(player).equals(PlayerState.Runner)){
                runner ++;
            }
        }
        return runner;
    }
}
