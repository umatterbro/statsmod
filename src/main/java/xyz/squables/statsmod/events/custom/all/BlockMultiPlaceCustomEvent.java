package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockMultiPlaceCustomEvent extends CustomEvent<BlockMultiPlaceEvent> {
    public BlockMultiPlaceCustomEvent() {
        super(0.01);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockMultiPlaceEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
