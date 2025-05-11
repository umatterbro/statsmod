package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityExhaustionEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityExhaustionCustomEvent extends CustomEvent<EntityExhaustionEvent> {
    public EntityExhaustionCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityExhaustionEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
