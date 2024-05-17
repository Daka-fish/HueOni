package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.ChatColor;

public enum PlayerState {
    Runner(ChatColor.AQUA),
    Chaser(ChatColor.RED);

    private ChatColor color;

    PlayerState(ChatColor color){
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }
}
