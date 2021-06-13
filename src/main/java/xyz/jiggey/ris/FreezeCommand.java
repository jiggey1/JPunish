package xyz.jiggey.ris;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.jiggey.JPunish;

public class FreezeCommand implements CommandExecutor {

    JPunish plugin;

    public FreezeCommand(JPunish freeze) {
        plugin = freeze;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (player.hasPermission("jpunish.gui.freeze")) {
            if (args.length == 1) {
                String targetName = args[0];

                if (Bukkit.getOfflinePlayer(targetName).getPlayer() != null) {
                    Player target = Bukkit.getPlayer(targetName);

                    if (plugin.frozenPlayers.containsKey(target)) {
                        plugin.frozenPlayers.remove(target);
                        player.sendMessage(ChatColor.YELLOW + targetName + ChatColor.GREEN + " has been unfrozen");
                        assert target != null;
                        target.sendMessage(ChatColor.YELLOW + "You" + ChatColor.GREEN + " have been unfrozen");
                    } else {
                        assert target != null;
                        plugin.frozenPlayers.put(target, target.getLocation().clone());
                        player.sendMessage(ChatColor.YELLOW + targetName + ChatColor.GREEN + " has been frozen");
                        target.sendMessage(ChatColor.YELLOW + "You" + ChatColor.GREEN + " have been frozen");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid player");
                }

            } else {
                player.sendMessage(ChatColor.RED + "You need to specify a player!");
                player.sendMessage(ChatColor.RED + "Correct usage: /Freeze (target)");
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
        }
        return true;
    }
}
