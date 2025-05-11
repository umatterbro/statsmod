package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.world.PortalCreateEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PotionSplashCustomEvent extends CustomEvent<PotionSplashEvent> {
    public PotionSplashCustomEvent() {
        super(0.3);
    }

    @Override
    @EventHandler
    public void handleEvent(PotionSplashEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
