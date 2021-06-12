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

    public static String banLengthOne;
    public static String banLengthTwo;
    public static String banLengthThree;
    public static String banLengthFour;

    public static String banItemOne;
    public static String banItemTwo;
    public static String banItemThree;
    public static String banItemFour;

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

        banLengthOne = this.getConfig().getString("banLengthOne");
        banLengthTwo = this.getConfig().getString("banLengthTwo");
        banLengthThree = this.getConfig().getString("banLengthThree");
        banLengthFour = this.getConfig().getString("banLengthFour");

        banItemOne = this.getConfig().getString("banItemOne");
        banItemTwo = this.getConfig().getString("banItemTwo");
        banItemThree = this.getConfig().getString("banItemThree");
        banItemFour = this.getConfig().getString("banItemFour");
    }

    @Override
    public void onEnable() {
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
