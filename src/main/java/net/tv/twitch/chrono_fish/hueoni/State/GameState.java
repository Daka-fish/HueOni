package net.tv.twitch.chrono_fish.hueoni.State;

import org.bukkit.ChatColor;

public enum GameState{
    Running(ChatColor.GREEN+"進行中"),
    Finished(ChatColor.GRAY+"準備中");

    String name;

    GameState(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
