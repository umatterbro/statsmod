package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class InventoryOpenCustomEvent extends CustomEvent<InventoryOpenEvent> {
    public InventoryOpenCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(InventoryOpenEvent e) {
        if(!(e.getPlayer() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
