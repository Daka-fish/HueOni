package net.tv.twitch.chrono_fish.hueoni;

import net.tv.twitch.chrono_fish.hueoni.CommandPack.HueOniCommands;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniEvent;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class HueOni extends JavaPlugin {

    private static HueOniGame hueOniGame;
    private static HashMap<Player, HueOniScoreBoard> hashMap;

    @Override
    public void onEnable() {
        hueOniGame = new HueOniGame();
        hashMap = new HashMap<>();
        getCommand("hueOni").setExecutor(new HueOniCommands());
        getServer().getPluginManager().registerEvents(new HueOniEvent(),this);
    }

    public static HueOniGame getGame(){
        return hueOniGame;
    }
    public static HashMap<Player, HueOniScoreBoard> getScoreMap(){
        return hashMap;
    }
}
