package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockPlaceCustomEvent extends CustomEvent<BlockPlaceEvent> {
    public BlockPlaceCustomEvent() {
        super(0.01);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
