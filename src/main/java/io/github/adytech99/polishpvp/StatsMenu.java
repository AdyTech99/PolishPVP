package io.github.adytech99.polishpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StatsMenu implements Listener {

    public static void open(Player player, int kills, int deaths) {
        Inventory inventory = Bukkit.createInventory(null, 9, "Player Stats");

        ItemStack killsItem = createItem(Material.DIAMOND_SWORD, ChatColor.RED + "Kills: " + kills);
        ItemStack deathsItem = createItem(Material.SKELETON_SKULL, ChatColor.RED + "Deaths: " + deaths);
        ItemStack kdrItem = createItem(Material.SHIELD, ChatColor.YELLOW + "KDR: " + kills/deaths);

        inventory.setItem(3, killsItem);
        inventory.setItem(4, kdrItem);
        inventory.setItem(5, deathsItem);

        player.openInventory(inventory);
    }

    private static ItemStack createItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if(meta != null) meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        return item;
    }
}
