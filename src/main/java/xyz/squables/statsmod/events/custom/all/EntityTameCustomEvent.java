package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityShootBowCustomEvent extends CustomEvent<EntityShootBowEvent> {
    public EntityShootBowCustomEvent() {
        super(0.175);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityShootBowEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
