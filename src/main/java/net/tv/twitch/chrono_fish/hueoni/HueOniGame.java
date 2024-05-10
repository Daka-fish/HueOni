package net.tv.twitch.chrono_fish.hueoni;

public class HueOniGame {
    private enum GameState{
        Running,
        Finished
    }

    GameState gameState;

    HueOniGame(){
        this.gameState = GameState.Finished;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
