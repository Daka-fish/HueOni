package net.tv.twitch.chrono_fish.taggame.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StateItem {

    public static void oniItem(Player player){
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.RED+"お仕置き棒");
        stick.setItemMeta(stickMeta);

        player.getInventory().clear();

        player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));

        player.getInventory().setItem(0,stick);
    }

    public static void runnerItem(Player player){
        player.getInventory().clear();
        player.getInventory().setItem(EquipmentSlot.HEAD,new ItemStack(Material.LEATHER_HELMET));
    }


}
