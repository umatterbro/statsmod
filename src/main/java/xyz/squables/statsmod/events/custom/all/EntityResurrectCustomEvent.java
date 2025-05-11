package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityRegainHealthCustomEvent extends CustomEvent<EntityRegainHealthEvent> {
    public EntityRegainHealthCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityRegainHealthEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
