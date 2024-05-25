package net.tv.twitch.chrono_fish.hueoni.GamePack;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    private GameState gameState;
    private HashMap<Player,PlayerState> map;

    public HueOniGame(){
        this.gameState = GameState.Finished;
        map = new HashMap<>();
    }

    public int getNumberOfFirstOni() {
        return 2;
    }

    public int countRunners(){
        int count = 0;
        for(Map.Entry<Player,PlayerState> entry : map.entrySet()){
            if(entry.getValue().equals(PlayerState.Chaser)) count += 1;
        }
        return count;
    }
    public int countChasers(){
        int count = 0;
        for(Map.Entry<Player,PlayerState> entry : map.entrySet()){
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

    public HashMap<Player, PlayerState> getMap() {
        return map;
    }
}
