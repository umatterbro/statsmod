package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerToggleSneakCustomEvent extends CustomEvent<PlayerToggleSneakEvent> {
    public PlayerToggleSneakCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
