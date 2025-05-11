package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockReceiveGameEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockReceiveGameCustomEvent extends CustomEvent<BlockReceiveGameEvent> {
    public BlockReceiveGameCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockReceiveGameEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
