package xyz.squables.statsmod.events.custom.all;

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityMountCustomEvent extends CustomEvent<EntityKnockbackByEntityEvent> {
    public EntityMountCustomEvent() {
        super(0.3);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityKnockbackByEntityEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
