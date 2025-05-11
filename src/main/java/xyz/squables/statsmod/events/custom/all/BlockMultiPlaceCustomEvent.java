package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockIgniteCustomEvent extends CustomEvent<BlockIgniteEvent> {
    public BlockIgniteCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockIgniteEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
