package org.plugins.nightlights;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.nightlights.config.NLConfig;
import org.plugins.nightlights.time.NightLightTime;

public final class NightLights extends JavaPlugin {

    private NLConfig nlConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Nightlights starting for world Kingdom");
        nlConfig = new NLConfig(this);

        //getServer().getPluginManager().registerEvents(new ServerTimeListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Nightlights turning off");
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NightLightTime time = new NightLightTime((int) getServer().getWorld("Kingdom").getTime());
        sender.sendMessage("Ticks: " + time.getTicks());
        sender.sendMessage("Hours: " + time.getHours());
        sender.sendMessage("Minutes: " + time.getMinutes());
        sender.sendMessage("Time: " + time.getTime());
        return (true);
    }
}
