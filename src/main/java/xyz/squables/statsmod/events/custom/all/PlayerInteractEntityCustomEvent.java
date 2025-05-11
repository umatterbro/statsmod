package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerInteractEntityCustomEvent extends CustomEvent<PlayerInteractEntityEvent> {
    public PlayerInteractEntityCustomEvent() {
        super(0.1);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
