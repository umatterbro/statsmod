package xyz.squables.statsmod.events.custom.all;

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityInteractEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityKnockbackByEntityCustomEvent extends CustomEvent<EntityKnockbackByEntityEvent> {
    public EntityKnockbackByEntityCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityKnockbackByEntityEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
