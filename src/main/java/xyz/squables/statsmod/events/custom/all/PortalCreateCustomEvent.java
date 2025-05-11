package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerVelocityCustomEvent extends CustomEvent<PlayerVelocityEvent> {
    public PlayerVelocityCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerVelocityEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
