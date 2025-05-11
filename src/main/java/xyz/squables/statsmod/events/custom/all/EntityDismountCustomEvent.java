package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDamageCustomEvent extends CustomEvent<EntityDamageEvent> {
    public EntityDamageCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
