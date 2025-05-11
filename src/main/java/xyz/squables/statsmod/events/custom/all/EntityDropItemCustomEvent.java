package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDismountEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDismountCustomEvent extends CustomEvent<EntityDismountEvent> {
    public EntityDismountCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityDismountEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
