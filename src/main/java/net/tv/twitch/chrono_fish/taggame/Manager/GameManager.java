package net.tv.twitch.chrono_fish.taggame.Manager;

import net.tv.twitch.chrono_fish.taggame.Instance.PlayerState;
import net.tv.twitch.chrono_fish.taggame.TagGame;
import net.tv.twitch.chrono_fish.taggame.Task.Countdown;
import net.tv.twitch.chrono_fish.taggame.Task.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameManager {

    private static TagGame main;

    public GameManager(TagGame main){
        GameManager.main = main;
    }

    public static void startGame(){
        if(StateManager.getRunner() >= ConfigManager.getRequiredPlayers()){
            new Countdown().runTaskTimer(main,0L,20L);
            new Timer().runTaskTimer(main,ConfigManager.getCountdownSeconds()* 20L,20L);
        }
    }

    public static void resetGame(){
        for(Player player: Bukkit.getOnlinePlayers()){
            StateManager.setState(player, PlayerState.Runner);
        }
    }

}
