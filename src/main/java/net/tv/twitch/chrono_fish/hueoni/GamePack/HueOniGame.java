package net.tv.twitch.chrono_fish.hueoni.GamePack;

import net.tv.twitch.chrono_fish.hueoni.HueOniScoreBoard;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    private GameState gameState;
    private HashMap<Player,PlayerState> stateHashMap;
    private static HashMap<Player, HueOniScoreBoard> scoreBoardHashMap;

    public HueOniGame(){
        this.gameState = GameState.Finished;
        stateHashMap = new HashMap<>();
        scoreBoardHashMap = new HashMap<>();
    }

    public int getNumberOfFirstOni() {
        return 2;
    }

    public int countRunners(){
        int count = 0;
        for(Map.Entry<Player,PlayerState> entry : stateHashMap.entrySet()){
            if(entry.getValue().equals(PlayerState.Chaser)) count += 1;
        }
        return count;
    }
    public int countChasers(){
        int count = 0;
        for(Map.Entry<Player,PlayerState> entry : stateHashMap.entrySet()){
            if(entry.getValue().equals(PlayerState.Chaser)) count += 1;
        }
        return count;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public GameState getGameState() {
        return gameState;
    }

    public HashMap<Player, PlayerState> getStateHashMap() {
        return stateHashMap;
    }

    public HashMap<Player, HueOniScoreBoard> getScoreBoardHashMap() {
        return scoreBoardHashMap;
    }
}
