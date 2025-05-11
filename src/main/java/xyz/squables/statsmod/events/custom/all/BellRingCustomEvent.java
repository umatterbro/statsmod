package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class AsyncPlayerChatCustomEvent extends CustomEvent<BlockBreakEvent> {
    public AsyncPlayerChatCustomEvent() {
        super(0.15);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
