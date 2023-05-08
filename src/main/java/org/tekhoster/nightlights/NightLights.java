package org.tekhoster.nightlights;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.tekhoster.nightlights.events.PlayerListener;

public final class NightLights extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting NightLights");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutting NightLights");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            sender.sendMessage("You must be an online operator to use this command");
        else {
            ItemStack tool = new ItemStack(Material.CLOCK);
            tool.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

            ItemMeta meta = tool.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.displayName(Component.text("hello"));

            tool.setItemMeta(meta);

            sender.sendMessage(tool.getItemFlags().toString());
            ((Player) sender).getInventory().setItemInMainHand(tool);
        }
        return (true);
    }
}
