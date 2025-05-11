package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockFertilizeCustomEvent extends CustomEvent<BlockFertilizeEvent> {
    public BlockFertilizeCustomEvent() {
        super(0.03);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockFertilizeEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
