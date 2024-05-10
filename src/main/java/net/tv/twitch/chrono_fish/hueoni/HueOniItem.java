package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HueOniItem {
    String itemName;
    ItemStack itemStack;
    List<String> lore;

    HueOniItem(){
        this.itemName = "default";
        this.itemStack = new ItemStack(Material.DIRT);
        itemStack.getItemMeta().setDisplayName(itemName);
        this.lore = new ArrayList<>();
    }
}