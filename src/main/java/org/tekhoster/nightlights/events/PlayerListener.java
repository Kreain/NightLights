package org.tekhoster.nightlights.events;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(@NotNull PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();



        assert block != null;
        BlockData data = block.getBlockData();

        if (event.getHand() == EquipmentSlot.HAND)
            player.sendMessage("Right Hand");
        else if (event.getHand() == EquipmentSlot.OFF_HAND)
            player.sendMessage("Off Hand");
        else
            player.sendMessage("It was " + Objects.requireNonNull(event.getHand()));

        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (data instanceof Lightable) {
                ((Lightable) data).setLit(!((Lightable) data).isLit());
                block.setBlockData(data);
            }
            player.sendMessage("You clicked '" + block.getType() + "'");
            player.sendMessage("With '" + event.getItem() + "'");
        }
    }
}
