package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityExplodeCustomEvent extends CustomEvent<EntityExplodeEvent> {
    public EntityExplodeCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityExplodeEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
