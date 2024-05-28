package net.tv.twitch.chrono_fish.hueoni.State;

import org.bukkit.ChatColor;

public enum PlayerState {
    Runner(ChatColor.AQUA+"逃げ"),
    Chaser(ChatColor.RED+"鬼");

    private String name;

    PlayerState(String s){
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
