package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseLootEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockDispenseLootCustomEvent extends CustomEvent<BlockDispenseLootEvent> {
    public BlockDispenseLootCustomEvent() {
        super(0.02);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockDispenseLootEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
