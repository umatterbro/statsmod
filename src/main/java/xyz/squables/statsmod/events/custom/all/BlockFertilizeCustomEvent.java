package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseLootEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockDropItemCustomEvent extends CustomEvent<BlockDropItemEvent> {
    public BlockDropItemCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockDropItemEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
