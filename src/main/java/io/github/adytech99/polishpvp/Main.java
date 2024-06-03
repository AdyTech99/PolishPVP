package io.github.adytech99.polishpvp;

import io.github.adytech99.polishpvp.commands.PVPCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    public Main(){}

    public static Main getInstance(){
        return new Main();
    }
    public FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.GREEN + "Enabled " + this.getName());
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("stats").setExecutor(new PVPCommands());
        getCommand("resetstats").setExecutor(new PVPCommands());
        getCommand("kit").setExecutor(new PVPCommands());

        this.saveDefaultConfig();
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(event.getEntity().getKiller() != null) {
            StatsHandler.onDeath(event.getEntity().getKiller(), event.getEntity());
            Player winner = event.getEntity().getKiller();
            if(config.getBoolean("do_health_reset")) winner.setHealth(winner.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            if(config.getBoolean("do_saturation_reset")) winner.setSaturation(6);
            if(config.getBoolean("do_hunger_reset")) winner.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Player Stats")){
            event.setCancelled(true); // Prevent players from taking items out of the inventory
        }
    }
}
