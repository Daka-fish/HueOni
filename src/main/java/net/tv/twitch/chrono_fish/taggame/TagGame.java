package net.tv.twitch.chrono_fish.taggame;

import net.tv.twitch.chrono_fish.taggame.Listener.GameListener;
import net.tv.twitch.chrono_fish.taggame.Listener.MainListener;
import net.tv.twitch.chrono_fish.taggame.Manager.ConfigManager;
import net.tv.twitch.chrono_fish.taggame.Manager.GameManager;
import net.tv.twitch.chrono_fish.taggame.Manager.StateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TagGame extends JavaPlugin {

    private StateManager stateManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.setConfig(this);
        setManager();
        setListener();
        getCommand("t").setExecutor(new Command());

    }

    public void setListener(){
        Bukkit.getPluginManager().registerEvents(new GameListener(),this);
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);
    }

    public void setManager(){
        this.stateManager = new StateManager();
        this.gameManager = new GameManager(this);

    }
}
