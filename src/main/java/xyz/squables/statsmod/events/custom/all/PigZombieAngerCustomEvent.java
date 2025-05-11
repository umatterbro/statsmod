package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PigZombieAngerEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PigZombieAngerCustomEvent extends CustomEvent<PigZombieAngerEvent> {
    public PigZombieAngerCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PigZombieAngerEvent e) {
        if(!(e.getTarget() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
