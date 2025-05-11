package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class EntityToggleSwimCustomEvent extends CustomEvent<EntityToggleSwimEvent> {
    public EntityToggleSwimCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(EntityToggleSwimEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
