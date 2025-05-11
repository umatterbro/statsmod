package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerUnleashEntityCustomEvent extends CustomEvent<PlayerUnleashEntityEvent> {
    public PlayerUnleashEntityCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerUnleashEntityEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
