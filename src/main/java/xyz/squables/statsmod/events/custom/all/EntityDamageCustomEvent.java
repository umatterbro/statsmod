package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDamageByEntityCustomEvent extends CustomEvent<EntityDamageByEntityEvent> {
    public EntityDamageByEntityCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
