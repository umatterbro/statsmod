package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerItemConsumeCustomEvent extends CustomEvent<PlayerItemConsumeEvent> {
    public PlayerItemConsumeCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
