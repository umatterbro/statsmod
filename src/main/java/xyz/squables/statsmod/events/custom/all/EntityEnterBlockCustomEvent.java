package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityEnterBlockCustomEvent extends CustomEvent<EntityEnterBlockEvent> {
    public EntityEnterBlockCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityEnterBlockEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
