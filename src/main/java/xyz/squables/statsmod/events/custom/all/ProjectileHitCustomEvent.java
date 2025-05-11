package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class ProjectileHitCustomEvent extends CustomEvent<ProjectileHitEvent> {
    public ProjectileHitCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(ProjectileHitEvent e) {
        if(!(e.getHitEntity() instanceof Player p)) return;
        this.doLightCheck(p, e);
    }
}
