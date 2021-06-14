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

public class mainWorker implements Listener, CommandExecutor {
    @SuppressWarnings("deprecation")
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

            Gui muteGui = new Gui(3, ChatColor.LIGHT_PURPLE + "Choose Mute Reason");
            muteGui.setDefaultClickAction(event -> {
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

            GuiItem muteItem = ItemBuilder.from(Material.PAPER).setName(ChatColor.GREEN + "Mute Player").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                if(player.hasPermission("jpunish.gui.muteUI")) {
                    muteGui.open(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission [ jpunish.gui.muteUI ] to access the MuteGUI!");
                }
            });

            GuiItem freezeItem = ItemBuilder.from(Material.ICE).setName(ChatColor.GREEN + "Freeze Player!").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                if(player.hasPermission("jpunish.ability.freeze")) {
                    Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                   mainGui.close(player);
                    player.performCommand("freeze " + mentionedPlayer.getName());
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission [ jpunish.ability.freeze ] to freeze people!");
                }
            });

            GuiItem backItem = ItemBuilder.from(Material.OAK_DOOR).setName(ChatColor.GRAY + "Go Back").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                mainGui.close(player);
            });


            // BanGui Items
            GuiItem banItem1 = ItemBuilder.from(Material.getMaterial(JPunish.banItemOne)).setName(ChatColor.GREEN + JPunish.banItemOneName).setLore(ChatColor.GREEN + "" + ChatColor.ITALIC + JPunish.banItemOneLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("ban " + mentionedPlayer.getName() + " " + JPunish.banLengthOne + " " + JPunish.banItemOneName);
                banGui.close(player);
            });

            GuiItem banItem2 = ItemBuilder.from(Material.getMaterial(JPunish.banItemTwo)).setName(ChatColor.YELLOW + JPunish.banItemTwoName).setLore(ChatColor.YELLOW + "" + ChatColor.ITALIC + JPunish.banItemTwoLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getServer().getPlayer(args[0]);
                player.performCommand("ban " + mentionedPlayer.getName() + " " + JPunish.banLengthTwo + " " + JPunish.banItemTwoName);
                banGui.close(player);
            });

            GuiItem banItem3 = ItemBuilder.from(Material.getMaterial(JPunish.banItemThree)).setName(ChatColor.GOLD + JPunish.banItemThreeName).setLore(ChatColor.GOLD + "" + ChatColor.ITALIC + JPunish.banItemThreeLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("ban " + mentionedPlayer.getName() + " " + JPunish.banLengthThree + " " + JPunish.banItemThreeName);
                banGui.close(player);
            });

            GuiItem banItem4 = ItemBuilder.from(Material.getMaterial(JPunish.banItemFour)).setName(ChatColor.RED + JPunish.banItemFourName).setLore(ChatColor.RED + "" + ChatColor.ITALIC + JPunish.banItemFourLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("ban " + mentionedPlayer.getName() + " " + JPunish.banLengthFour + " " + JPunish.banItemFourName);
                banGui.close(player);
            });

            GuiItem backItem2 = ItemBuilder.from(Material.OAK_DOOR).setName(ChatColor.GRAY + "Go Back").asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                mainGui.open(player);
            });


            // KickGUI Items
            GuiItem kickItem1 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemOne)).setName(ChatColor.GREEN + JPunish.kickItemOneName).setLore(ChatColor.GREEN + "" + ChatColor.ITALIC + JPunish.kickItemOneLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("kick " + mentionedPlayer.getName() + " " + JPunish.kickItemOneName);
                kickGui.close(player);
            });

            GuiItem kickItem2 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemTwo)).setName(ChatColor.GOLD + JPunish.kickItemTwoName).setLore(ChatColor.GOLD + "" + ChatColor.ITALIC + JPunish.kickItemTwoLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("kick " + mentionedPlayer.getName() + " " + JPunish.kickItemTwoName);
                kickGui.close(player);
            });

            GuiItem kickItem3 = ItemBuilder.from(Material.getMaterial(JPunish.kickItemThree)).setName(ChatColor.RED + JPunish.kickItemThreeName).setLore(ChatColor.RED + "" + ChatColor.ITALIC + JPunish.kickItemThreeLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("kick " + mentionedPlayer.getName() + " " + JPunish.kickItemThreeName);
                kickGui.close(player);
            });


            // MuteGUI Items
            GuiItem muteItem1 = ItemBuilder.from(Material.getMaterial(JPunish.muteItemOne)).setName(ChatColor.GREEN + JPunish.muteItemOneName).setLore(ChatColor.GREEN + "" + ChatColor.ITALIC + JPunish.muteItemOneLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("mute " + mentionedPlayer.getName() + " " + JPunish.muteLengthOne + " " + JPunish.muteItemOneName);
                muteGui.close(player);
            });

            GuiItem muteItem2 = ItemBuilder.from(Material.getMaterial(JPunish.muteItemTwo)).setName(ChatColor.GOLD + JPunish.muteItemTwoName).setLore(ChatColor.GOLD + "" + ChatColor.ITALIC + JPunish.muteItemTwoLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("mute " + mentionedPlayer.getName() + " " + JPunish.muteLengthTwo + " " + JPunish.muteItemTwoName);
                muteGui.close(player);
            });

            GuiItem muteItem3 = ItemBuilder.from(Material.getMaterial(JPunish.muteItemThree)).setName(ChatColor.RED + JPunish.muteItemThreeName).setLore(ChatColor.RED + "" + ChatColor.ITALIC + JPunish.muteItemThreeLore).asGuiItem(event -> {
                Player player = (Player) event.getWhoClicked();
                Player mentionedPlayer = Bukkit.getPlayerExact(args[0]);
                player.performCommand("mute " + mentionedPlayer.getName() + " " + JPunish.muteLengthThree + " " + JPunish.muteItemThreeName);
                muteGui.close(player);
            });



            // MainGUI Layout
            mainGui.setItem(2, 2, banItem);
            mainGui.setItem(2, 4, kickItem);
            mainGui.setItem(2, 6, muteItem);
            mainGui.setItem(2, 8, freezeItem);
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

            // MuteGUI Layout
            muteGui.setItem(2, 3, muteItem1);
            muteGui.setItem(2, 5, muteItem2);
            muteGui.setItem(2, 7, muteItem3);
            muteGui.setItem(3, 9, backItem2);

            muteGui.getFiller().fill(ItemBuilder.from(Material.GLASS_PANE).setName("§ka").asGuiItem());


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