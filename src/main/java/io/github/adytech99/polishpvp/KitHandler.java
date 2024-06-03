package io.github.adytech99.polishpvp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitHandler {
    public static void giveKit(Player player){
        player.getInventory().clear();
        player.getInventory().setHelmet(createUnbreakableItem(new ItemStack(Material.DIAMOND_HELMET)));
        player.getInventory().setChestplate(createUnbreakableItem(new ItemStack(Material.DIAMOND_CHESTPLATE)));
        player.getInventory().setLeggings(createUnbreakableItem(new ItemStack(Material.DIAMOND_LEGGINGS)));
        player.getInventory().setBoots(createUnbreakableItem(new ItemStack( Material.DIAMOND_BOOTS)));
        player.getInventory().setItemInOffHand(createUnbreakableItem(new ItemStack(Material.SHIELD)));

        player.getInventory().setItem(0, (createUnbreakableItem(new ItemStack(Material.DIAMOND_SWORD))));
        player.getInventory().setItem(1, (createUnbreakableItem(new ItemStack(Material.DIAMOND_AXE))));

        ItemStack food = new ItemStack(Material.COOKED_BEEF);
        food = createUnbreakableItem(food);
        food.setAmount(64);
        player.getInventory().setItem(2, food);

        player.sendMessage("[PolishPVP] Kit given.");
    }

    private static ItemStack createUnbreakableItem(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        }
        return item;
    }
}
