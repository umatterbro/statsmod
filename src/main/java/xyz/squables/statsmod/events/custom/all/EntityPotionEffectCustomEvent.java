package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityPotionEffectCustomEvent extends CustomEvent<EntityPotionEffectEvent> {
    public EntityPotionEffectCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityPotionEffectEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
