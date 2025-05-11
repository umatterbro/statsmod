package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTameEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityTameCustomEvent extends CustomEvent<EntityTameEvent> {
    public EntityTameCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityTameEvent e) {
        if(!(e.getOwner() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
