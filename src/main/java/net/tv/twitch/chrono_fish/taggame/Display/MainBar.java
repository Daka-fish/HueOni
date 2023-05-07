package net.tv.twitch.chrono_fish.taggame.Display;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class MainBar {
    private static BossBar bossbar;

    public static void setBar(Player player){
        bossbar = Bukkit.createBossBar("-増え鬼-", BarColor.GREEN, BarStyle.SEGMENTED_20);
        bossbar.addPlayer(player);
    }
}
