package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDamageByBlockCustomEvent extends CustomEvent<EntityDamageByBlockEvent> {
    public EntityDamageByBlockCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityDamageByBlockEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
