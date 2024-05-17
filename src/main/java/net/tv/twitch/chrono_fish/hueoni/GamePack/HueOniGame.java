package net.tv.twitch.chrono_fish.hueoni.GamePack;

import java.util.ArrayList;
import java.util.List;

public class HueOniGame {
    public enum GameState{
        Running,
        Finished
    }

    GameState gameState;
    List<HueOniPlayer> runnerList = new ArrayList<>();
    List<HueOniPlayer> chaserList = new ArrayList<>();

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
    public void putKillList(HueOniPlayer player){chaserList.add(player);}

    public int getNumberOfRunners(){return runnerList.size();}
    public int getNumberOfChasers(){return chaserList.size();}
}
