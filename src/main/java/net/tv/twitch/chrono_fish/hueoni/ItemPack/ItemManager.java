package net.tv.twitch.chrono_fish.hueoni.ItemPack;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ItemManager {

    private HashMap<String, HueOniItem> itemList;

    public ItemManager(){
        itemList = new HashMap<>();
    }

    public void loadItems(){
        HueOniItem stick = new HueOniItem("叩き棒",new ItemStack(Material.STICK));
        itemList.put("stick",stick);
    }

    public HashMap<String, HueOniItem> getItemMap(){
        return itemList;
    }
}
