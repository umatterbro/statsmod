package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class AsyncPlayerChatCustomEvent extends CustomEvent<AsyncPlayerChatEvent> {
    public AsyncPlayerChatCustomEvent() {
        super(0.15);
    }

    @Override
    @EventHandler
    public void handleEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
