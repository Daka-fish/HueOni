package net.tv.twitch.chrono_fish.hueoni.GamePack;

import net.tv.twitch.chrono_fish.hueoni.HueOni;
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
            hueOniGame.setTime(100);
            Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateTime(currentTime));
            Bukkit.broadcastMessage("時間切れ!");
            return;
        }

        hueOniGame.setTime(currentTime-1);
        Bukkit.getOnlinePlayers().forEach(player -> hueOniGame.getScoreBoardHashMap().get(player).updateTime(currentTime));
    }
}
