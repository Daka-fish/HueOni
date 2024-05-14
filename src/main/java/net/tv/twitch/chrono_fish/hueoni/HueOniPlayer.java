package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class HueOniPlayer {

    Player player;
    Inventory inv;

    HueOniPlayer(Player player){
        this.player = player;
        this.inv = player.getInventory();
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInv() {
        return inv;
    }
}
