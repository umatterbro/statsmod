package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BellRingEvent;
import org.bukkit.event.block.BlockBreakEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BellRingCustomEvent extends CustomEvent<BellRingEvent> {
    public BellRingCustomEvent() {
        super(1);
    }

    @Override
    @EventHandler
    public void handleEvent(BellRingEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
