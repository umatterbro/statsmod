package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityPortalCustomEvent extends CustomEvent<EntityPortalEvent> {
    public EntityPortalCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityPortalEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
