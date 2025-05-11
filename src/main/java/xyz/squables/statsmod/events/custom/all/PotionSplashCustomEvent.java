package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.event.world.PortalCreateEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PortalCreateCustomEvent extends CustomEvent<PortalCreateEvent> {
    public PortalCreateCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PortalCreateEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
