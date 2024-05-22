package net.tv.twitch.chrono_fish.hueoni;

import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import org.bukkit.plugin.java.JavaPlugin;

public final class HueOn extends JavaPlugin {

    HueOniGame hueOniGame;

    @Override
    public void onEnable() {
        hueOniGame = new HueOniGame();
    }

    public HueOniGame getGame(){
        return hueOniGame;
    }
}
