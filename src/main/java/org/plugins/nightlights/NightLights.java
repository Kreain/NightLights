package org.plugins.nightlights;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.nightlights.config.NLConfig;

public final class NightLights extends JavaPlugin {

    private NLConfig nlConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Nightlights starting for world Kingdom");

        //getServer().getPluginManager().registerEvents(new ServerTimeListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Nightlights turning off");
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(String.valueOf(getServer().getWorld("Kingdom").getTime()));
        return (true);
    }
}
