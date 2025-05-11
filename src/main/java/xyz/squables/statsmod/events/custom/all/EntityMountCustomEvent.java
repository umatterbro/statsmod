package xyz.squables.statsmod.events.custom.all;

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityMountEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityMountCustomEvent extends CustomEvent<EntityMountEvent> {
    public EntityMountCustomEvent() {
        super(0.3);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityMountEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
