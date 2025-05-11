package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityInteractCustomEvent extends CustomEvent<EntityInteractEvent> {
    public EntityInteractCustomEvent() {
        super(0.1);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityInteractEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
