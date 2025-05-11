package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerMoveCustomEvent extends CustomEvent<PlayerMoveEvent> {
    public PlayerMoveCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
