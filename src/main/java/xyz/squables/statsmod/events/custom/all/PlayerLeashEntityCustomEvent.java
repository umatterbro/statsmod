package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerLeashEntityCustomEvent extends CustomEvent<PlayerLeashEntityEvent> {
    public PlayerLeashEntityCustomEvent() {
        super(0.4);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerLeashEntityEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
