package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockDamageCustomEvent extends CustomEvent<BlockDamageEvent> {
    public BlockDamageCustomEvent() {
        super(0.01);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockDamageEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
