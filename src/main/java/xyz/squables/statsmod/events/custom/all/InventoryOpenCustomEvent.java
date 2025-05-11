package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class InventoryMoveItemCustomEvent extends CustomEvent<InventoryMoveItemEvent> {
    public InventoryMoveItemCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(InventoryMoveItemEvent e) {
        if(!(e. instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
