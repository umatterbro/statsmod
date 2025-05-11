package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class RaidTriggerCustomEvent extends CustomEvent<RaidTriggerEvent> {
    public RaidTriggerCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(RaidTriggerEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
