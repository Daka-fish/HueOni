package net.tv.twitch.chrono_fish.hueoni;

import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeManager extends BukkitRunnable {

    private final HueOniGame hueOniGame;

    public TimeManager(){
        hueOniGame = HueOni.getGame();
    }

    @Override
    public void run() {
        int currentTime = hueOniGame.getTime();

        if(currentTime==0){
            cancel();
            Bukkit.broadcastMessage("終了!");
            hueOniGame.setTime(100);
            Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateTime(currentTime));
            return;
        }

        hueOniGame.setTime(currentTime-1);
        Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateTime(currentTime));
    }
}
