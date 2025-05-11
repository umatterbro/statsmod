package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class SheepDyeWoolCustomEvent extends CustomEvent<SheepDyeWoolEvent> {
    public SheepDyeWoolCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(SheepDyeWoolEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
