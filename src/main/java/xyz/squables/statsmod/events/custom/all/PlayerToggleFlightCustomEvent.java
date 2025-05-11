package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerToggleFlightCustomEvent extends CustomEvent<PlayerToggleFlightEvent> {
    public PlayerToggleFlightCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
