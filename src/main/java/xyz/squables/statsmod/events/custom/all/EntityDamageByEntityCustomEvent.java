package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityDamageByBlockCustomEvent extends CustomEvent<EnchantItemEvent> {
    public EntityDamageByBlockCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(EnchantItemEvent e) {
        Player p = e.getEnchanter();
        this.doLightCheck(p, e);
    }
}
