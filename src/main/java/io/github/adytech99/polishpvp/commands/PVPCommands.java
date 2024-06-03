package io.github.adytech99.polishpvp.commands;

import io.github.adytech99.polishpvp.StatsHandler;
import io.github.adytech99.polishpvp.KitHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PVPCommands implements CommandExecutor {

    public PVPCommands(){
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("kit")) {
                KitHandler.giveKit(player);
            }
            else if(command.getName().equalsIgnoreCase("stats")){
                StatsHandler.sendStats(player);
            }
            else if(command.getName().equalsIgnoreCase("resetstats")){
                if(args.length > 0 && args[0].equalsIgnoreCase("confirm")){
                    StatsHandler.resetStats(player);
                    player.sendMessage("[PolishPVP] Statistics reset");
                }
                else player.sendMessage("[PolishPVP] Type /resetstats confirm");
            }
        }
        return true;
    }
}
