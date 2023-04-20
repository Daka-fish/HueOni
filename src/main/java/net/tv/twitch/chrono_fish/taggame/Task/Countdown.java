package net.tv.twitch.chrono_fish.taggame.Task;

import net.tv.twitch.chrono_fish.taggame.Manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private static int countdownSeconds = ConfigManager.getCountdownSeconds();

    @Override
    public void run() {
        if(countdownSeconds == 0){
            cancel();
            for(Player player : Bukkit.getOnlinePlayers()){
                player.sendTitle(ChatColor.GOLD + "Start!","");
            }
        }
        Bukkit.broadcastMessage("開始まで,"+ countdownSeconds +"秒");

        countdownSeconds --;
    }
}
