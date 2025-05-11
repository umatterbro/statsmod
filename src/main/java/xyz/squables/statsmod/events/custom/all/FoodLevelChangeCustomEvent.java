package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class FoodLevelChangeCustomEvent extends CustomEvent<FoodLevelChangeEvent> {
    public FoodLevelChangeCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(FoodLevelChangeEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
