package net.tv.twitch.chrono_fish.hueoni.ItemPack;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HueOniItem {
    private final String itemName;
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    HueOniItem(String name, ItemStack is){
        this.itemName = name;
        this.itemStack = is;
        this.itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(itemName));
    }

    public String getItemName() {
        return itemName;
    }
    public ItemStack getItemStack() {
        return itemStack;
    }
}