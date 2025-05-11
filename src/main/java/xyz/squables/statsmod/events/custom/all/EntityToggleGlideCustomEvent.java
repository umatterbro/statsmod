package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityToggleGlideCustomEvent extends CustomEvent<EntityToggleGlideEvent> {
    public EntityToggleGlideCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityToggleGlideEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
