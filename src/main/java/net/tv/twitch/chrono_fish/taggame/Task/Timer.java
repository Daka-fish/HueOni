package net.tv.twitch.chrono_fish.taggame.Task;

import net.tv.twitch.chrono_fish.taggame.Manager.ConfigManager;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private static int timerseconds = ConfigManager.getTimerSeconds();
    @Override
    public void run() {
        timerseconds --;
    }
}
