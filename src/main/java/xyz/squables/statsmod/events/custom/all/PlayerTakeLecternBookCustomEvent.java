package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerSwapHandItemsCustomEvent extends CustomEvent<PlayerSwapHandItemsEvent> {
    public PlayerSwapHandItemsCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
