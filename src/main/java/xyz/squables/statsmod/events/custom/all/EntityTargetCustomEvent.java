package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityTargetCustomEvent extends CustomEvent<EntityTargetEvent> {
    public EntityTargetCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityTargetEvent e) {
        if(!(e.getTarget() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
