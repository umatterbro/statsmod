package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerPickupArrowCustomEvent extends CustomEvent<PlayerPickupArrowEvent> {
    public PlayerPickupArrowCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerPickupArrowEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
