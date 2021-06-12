package xyz.jiggey;

import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.jiggey.gui.mainGui;

public final class JPunish extends JavaPlugin implements Listener {
    public Permission permission;

    public static String banItemOneName;
    public static String banItemTwoName;
    public static String banItemThreeName;
    public static String banItemFourName;
    public static String banItemOneLore;
    public static String banItemTwoLore;
    public static String banItemThreeLore;
    public static String banItemFourLore;

    public JPunish() {
        // GUI Permissions
        this.permission = new Permission("jpunish.gui.access"); // This permission is for GUI Access
        this.permission = new Permission("jpunish.gui.banUI"); // This permission is for Ban GUI Access
        this.permission = new Permission("jpunish.gui.kickUI"); // This permission is for Kick GUi Access
        this.permission = new Permission("jpunish.gui.muteUI"); // This permission is for Mute GUi Access

        // Punishment Permissions
        this.permission = new Permission("jpunish.punishment.ban"); // This permission grants access to banning players

        // Config File Shit
        banItemOneName = this.getConfig().getString("banItemOneName");
        banItemTwoName = this.getConfig().getString("banItemTwoName");
        banItemThreeName = this.getConfig().getString("banItemThreeName");
        banItemFourName = this.getConfig().getString("banItemFourName");
        banItemOneLore= this.getConfig().getString("banItemOneLore");
        banItemTwoLore= this.getConfig().getString("banItemTwoLore");
        banItemThreeLore = this.getConfig().getString("banItemThreeLore");
        banItemFourLore = this.getConfig().getString("banItemFourLore");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Loading and reading the config file...");
        this.getLogger().info("Finished! Initializing...");
        this.getLogger().info("JPunish Has Been Enabled Successfully!");
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.addPermission(this.permission);

        // Commands Will Go Here
        getCommand("punish").setExecutor((new mainGui()));

        // Event Registering Will Go Here
        getServer().getPluginManager().registerEvents(this, this);

        this.saveDefaultConfig();
        this.reloadConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        this.getLogger().info("JPunish Has Been Disabled, Goodbye.");
    }
}
