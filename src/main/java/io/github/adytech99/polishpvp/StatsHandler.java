package io.github.adytech99.polishpvp;


import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class StatsHandler extends JavaPlugin {
    public static void onDeath(Player winner, Player noob){
        saveIntegerToPlayer(winner, getIntegerFromPlayer(winner, "kills") + 1, "kills");
        saveIntegerToPlayer(noob, getIntegerFromPlayer(noob, "deaths") + 1, "deaths");
    }

    public static void sendStats(Player player){
        StatsMenu.open(player, getIntegerFromPlayer(player, "kills"), getIntegerFromPlayer(player, "deaths"));
    }

    public static void resetStats(Player player){
        saveIntegerToPlayer(player, 0, "kills");
        saveIntegerToPlayer(player, 0, "deaths");
    }

    public static void saveIntegerToPlayer(Player player, int value, @NonNull String key) {
        if(!Objects.equals(key, "deaths") && !Objects.equals(key, "kills")) {
            player.sendMessage("An unexpected error occurred. Unable to update stats");
            return;
        }
        NamespacedKey namespacedKey = new NamespacedKey("polishpvp", key);
        player.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, value);
    }


    public static int getIntegerFromPlayer(Player player, String key) {
        if(!Objects.equals(key, "deaths") && !Objects.equals(key, "kills")) {
            player.sendMessage("An unexpected error occurred. Unable to update stats");
            return 0;
        }
        NamespacedKey namespacedKey = new NamespacedKey("polishpvp", key);
        return player.getPersistentDataContainer().getOrDefault(namespacedKey, PersistentDataType.INTEGER, 0);
    }
}
