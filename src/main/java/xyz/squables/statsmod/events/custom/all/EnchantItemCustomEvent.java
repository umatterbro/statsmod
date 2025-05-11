package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockShearEntityEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class CauldronLevelChangeCustomEvent extends CustomEvent<CauldronLevelChangeEvent> {
    public CauldronLevelChangeCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(CauldronLevelChangeEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
