package net.tv.twitch.chrono_fish.hueoni.GamePack;

import net.tv.twitch.chrono_fish.hueoni.HueOniScoreBoard;
import net.tv.twitch.chrono_fish.hueoni.State.GameState;
import net.tv.twitch.chrono_fish.hueoni.State.PlayerState;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HueOniGame {

    private int time;
    private GameState gameState;
    private final HashMap<String, PlayerState> stateHashMap;
    private final HashMap<Player, HueOniScoreBoard> scoreBoardHashMap;

    public HueOniGame(){
        this.time = 100;
        this.gameState = GameState.Finished;
        stateHashMap = new HashMap<>();
        scoreBoardHashMap = new HashMap<>();
    }

    public int getNumberOfFirstOni() {
        return 2;
    }

    public int countRunners(){
        int count = 0;
        for(Map.Entry<String,PlayerState> entry : stateHashMap.entrySet()){
            if(entry.getValue().equals(PlayerState.Runner)) count += 1;
        }
        return count;
    }
    public int countChasers(){
        int count = 0;
        for(Map.Entry<String,PlayerState> entry : stateHashMap.entrySet()){
            if(entry.getValue().equals(PlayerState.Chaser)) count += 1;
        }
        return count;
    }

    public void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return time;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public GameState getGameState() {
        return gameState;
    }

    public HashMap<String, PlayerState> getStateHashMap() {
        return stateHashMap;
    }
    public HashMap<Player, HueOniScoreBoard> getScoreBoardHashMap() {
        return scoreBoardHashMap;
    }
}
