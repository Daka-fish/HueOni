package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class HueOniPlayer {

    Player player;
    String playerName;
    Inventory inv;

    PlayerState state;

    HueOniPlayer(Player player){
        this.player = player;
        this.playerName = player.getName();
        this.inv = player.getInventory();
        this.state = PlayerState.Runner;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInv() {
        return inv;
    }
}
