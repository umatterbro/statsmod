package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityPortalExitCustomEvent extends CustomEvent<EntityPortalExitEvent> {
    public EntityPortalExitCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityPortalExitEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
