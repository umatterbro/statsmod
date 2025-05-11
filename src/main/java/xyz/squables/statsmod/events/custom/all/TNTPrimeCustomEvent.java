package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class TNTPrimeCustomEvent extends CustomEvent<TNTPrimeEvent> {
    public TNTPrimeCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(TNTPrimeEvent e) {
        if(!(e.getPrimingEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
