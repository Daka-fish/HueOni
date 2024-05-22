package net.tv.twitch.chrono_fish.hueoni.GamePack;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    GameState gameState;

    HashMap<Player,PlayerState> map = new HashMap<>();

    public HueOniGame(){
        this.gameState = GameState.Finished;
    }

    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNumberOfChasers(){
        int count = 0;
        for(Map.Entry<Player,PlayerState> entry : map.entrySet()){
            if(entry.getValue().equals(PlayerState.Chaser)) count += 1;
        }
        return count;
    }

    public boolean RunnerExist(){
        for(Map.Entry<Player,PlayerState> entry : map.entrySet()){
            if(entry.getValue().equals(PlayerState.Runner)) return true;
        }
        return false;
    }

    public HashMap<Player, PlayerState> getMap() {
        return map;
    }

    public PlayerState getPlayerState(Player player){
        return map.get(player);
    }

    public void putToMap(Player player, PlayerState state){map.put(player,state);}
}
