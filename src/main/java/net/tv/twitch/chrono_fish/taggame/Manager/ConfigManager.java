package net.tv.twitch.chrono_fish.taggame.Manager;

import net.tv.twitch.chrono_fish.taggame.TagGame;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setConfig(TagGame main){
        config = main.getConfig();
        main.saveDefaultConfig();
    }

    public static int getRequiredPlayers(){
        return config.getInt("required-players");
    }

    public static int getCountdownSeconds(){return config.getInt("countdown-seconds");}

    public static int getTimerSeconds(){return config.getInt("timer-seconds");}

}
