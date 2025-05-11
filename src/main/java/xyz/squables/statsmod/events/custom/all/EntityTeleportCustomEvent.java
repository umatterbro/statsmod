package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityTeleportCustomEvent extends CustomEvent<EntityTeleportEvent> {
    public EntityTeleportCustomEvent() {
        super(0.35);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityTeleportEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
