package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityResurrectEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityResurrectCustomEvent extends CustomEvent<EntityResurrectEvent> {
    public EntityResurrectCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityResurrectEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
