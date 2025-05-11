package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityTargetLivingEntityCustomEvent extends CustomEvent<EntityTargetLivingEntityEvent> {
    public EntityTargetLivingEntityCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityTargetLivingEntityEvent e) {
        if(!(e.getTarget() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
