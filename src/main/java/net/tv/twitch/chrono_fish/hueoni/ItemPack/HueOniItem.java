package net.tv.twitch.chrono_fish.hueoni.ItemPack;

import org.bukkit.inventory.ItemStack;

public class HueOniItem {
    String itemName;
    ItemStack itemStack;

    HueOniItem(String name, ItemStack is){
        this.itemName = name;
        this.itemStack = is;
        itemStack.getItemMeta().setDisplayName(itemName);
    }
}