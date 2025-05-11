package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EnchantItemCustomEvent extends CustomEvent<EnchantItemEvent> {
    public EnchantItemCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(EnchantItemEvent e) {
        Player p = e.getEnchanter();
        this.doLockCheck(p, e);
    }
}
