package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerInteractAtEntityCustomEvent extends CustomEvent<PlayerHarvestBlockEvent> {
    public PlayerInteractAtEntityCustomEvent() {
        super(0.05);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerHarvestBlockEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
