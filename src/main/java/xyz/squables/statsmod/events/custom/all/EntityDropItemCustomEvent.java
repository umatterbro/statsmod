package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDropItemCustomEvent extends CustomEvent<EntityDropItemEvent> {
    public EntityDropItemCustomEvent() {
        super(0.1);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityDropItemEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
