package org.plugins.nightlights.config;

import org.bukkit.plugin.Plugin;

import java.io.File;

public class NLConfig {

    private final Plugin plugin;

    public NLConfig(Plugin plugin) {
        this.plugin = plugin;
        File folder = plugin.getDataFolder();
        if (!folder.exists())
            folder.mkdirs();

        plugin.saveDefaultConfig();
    }
}
