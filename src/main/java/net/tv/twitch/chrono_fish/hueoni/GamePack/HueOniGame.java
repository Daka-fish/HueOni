package net.tv.twitch.chrono_fish.hueoni.GamePack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    GameState gameState;
    List<Player> runnerList = new ArrayList<>();
    List<Player> chaserList = new ArrayList<>();

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

    public List<Player> getRunnerList() {
        return runnerList;
    }
    public List<Player> getChaserList() {
        return chaserList;
    }

    public int getNumberOfRunners(){return runnerList.size();}
    public int getNumberOfChasers(){return chaserList.size();}

    public void putToMap(Player player, PlayerState state){map.put(player,state);}
}
