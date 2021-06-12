package xyz.jiggey.gui;

import me.mattstudios.mfgui.gui.components.util.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import xyz.jiggey.JPunish;

public class mainGui implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            // GUI Sections
            Gui mainGui = new Gui(3, ChatColor.RED + "Punishment GUI");
            mainGui.setDefaultClickAction(event -> {
                event.setCancelled(true);
            });

            Gui banGui = new Gui(3, ChatColor.LIGHT_PURPLE + "Choose Ban Reason");
            banGui.setDefaultClickAction(event -> {
                event.setCancelled(true);
            });

            Gui kickGui = new Gui(3, ChatColor.LIGHT_PURPLE + "Choose Kick Reason");
            kickGui.setDefaultClickAction(event -> {
                event.setCancelled(true);
            });


            // MainGUI Items
            GuiItem banItem = ItemBuilder.from(Material.BARRIER).setName(ChatColor.RED + "Ban Player").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                if(player.hasPermission("jpunish.gui.banUI")) {
                    banGui.open(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission [ jpunish.gui.banUI ] to access the BanGUI!");
                }
            });

            GuiItem kickItem = ItemBuilder.from(Material.BLAZE_ROD).setName(ChatColor.GOLD + "Kick Player").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                if(player.hasPermission("jpunish.gui.kickUI")) {
                    kickGui.open(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission [ jpunish.gui.kickUI ] to access the KickGUI!");
                }
            });

            GuiItem backItem = ItemBuilder.from(Material.OAK_DOOR).setName(ChatColor.GRAY + "Go Back").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                mainGui.close(player);
            });


            // BanGui Items
            GuiItem banItem1 = ItemBuilder.from(Material.getMaterial(JPunish.banItemOne)).setName(ChatColor.GREEN + JPunish.banItemOneName).setLore(ChatColor.GREEN + JPunish.banItemOneLore).asGuiItem();

            GuiItem banItem2 = ItemBuilder.from(Material.getMaterial(JPunish.banItemTwo)).setName(ChatColor.YELLOW + JPunish.banItemTwoName).setLore(ChatColor.YELLOW + JPunish.banItemTwoLore).asGuiItem();

            GuiItem banItem3 = ItemBuilder.from(Material.getMaterial(JPunish.banItemThree)).setName(ChatColor.GOLD + JPunish.banItemThreeName).setLore(ChatColor.GOLD + JPunish.banItemThreeLore).asGuiItem();

            GuiItem banItem4 = ItemBuilder.from(Material.getMaterial(JPunish.banItemFour)).setName(ChatColor.RED + JPunish.banItemFourName).setLore(ChatColor.RED + JPunish.banItemFourLore).asGuiItem();

            GuiItem backItem2 = ItemBuilder.from(Material.OAK_DOOR).setName(ChatColor.GRAY + "Go Back").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                mainGui.open(player);
            });


            // KickGUI Items
            GuiItem kickItem1 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemOne)).setName(ChatColor.GREEN + JPunish.kickItemOneName).setLore(ChatColor.GREEN + JPunish.kickItemOneLore).asGuiItem();

            GuiItem kickItem2 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemTwo)).setName(ChatColor.GOLD + JPunish.kickItemTwoName).setLore(ChatColor.GOLD + JPunish.kickItemTwoLore).asGuiItem();

            GuiItem kickItem3 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemThree)).setName(ChatColor.RED + JPunish.kickItemThreeName).setLore(ChatColor.RED + JPunish.kickItemThreeLore).asGuiItem();


            // MainGUI Layout
            mainGui.setItem(2, 2, banItem);
            mainGui.setItem(2, 4, kickItem);
            mainGui.setItem(3, 9, backItem);

            mainGui.getFiller().fill(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName("§ka").asGuiItem());


            // BanGUI Layout
            banGui.setItem(2, 2, banItem1);
            banGui.setItem(2, 4, banItem2);
            banGui.setItem(2, 6, banItem3);
            banGui.setItem(2, 8, banItem4);
            banGui.setItem(3, 9, backItem2);

            banGui.getFiller().fill(ItemBuilder.from(Material.GLASS_PANE).setName("§ka").asGuiItem());

            // KickGUI Layout
            kickGui.setItem(2, 3, kickItem1);
            kickGui.setItem(2, 5, kickItem2);
            kickGui.setItem(2, 7, kickItem3);
            kickGui.setItem(3, 9, backItem2);

            kickGui.getFiller().fill(ItemBuilder.from(Material.GLASS_PANE).setName("§ka").asGuiItem());


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("jpunish.gui.access")) {
                if (command.getName().equalsIgnoreCase("punish")) {
                    if(args.length == 0) {
                        player.sendMessage(ChatColor.RED + "You need to mention a player! You can't punish the air!");
                        return true;
                    } else {
                        Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                        if (mentionedPlayer == null) {
                            player.sendMessage(ChatColor.RED + "That player is not online or doesn't exist. Please try again!");
                            return true;
                        }
                        if (mentionedPlayer == player) {
                            player.sendMessage(ChatColor.RED + "You can't punish yourself!");
                            return true;
                        }
                        if (mentionedPlayer != null) {
                            mainGui.open(player);
                        }
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You Lack The Permissions To Execute This Command!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You can only run this command as a player.");
        }
        return true;
    }
}
