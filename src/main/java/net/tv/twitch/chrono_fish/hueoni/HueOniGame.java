package net.tv.twitch.chrono_fish.hueoni;

import java.util.ArrayList;
import java.util.List;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    GameState gameState;
    List<HueOniPlayer> runnerList = new ArrayList<>();
    List<HueOniPlayer> killerList = new ArrayList<>();

    HueOniGame(){
        this.gameState = GameState.Finished;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void putRunList(HueOniPlayer player){runnerList.add(player);}
    public void putKillList(HueOniPlayer player){killerList.add(player);}

    public int getRunners(){return runnerList.size();}
    public int getKillers(){return killerList.size();}
}
