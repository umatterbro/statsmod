package xyz.squables.statsmod.events.custom.block;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerBreakBlockCustomEvent extends CustomEvent<BlockBreakEvent> {
    public PlayerBreakBlockCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
