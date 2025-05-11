package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerBedEnterCustomEvent extends CustomEvent<PlayerBedEnterEvent> {
    public PlayerBedEnterCustomEvent() {
        super(0.75);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
