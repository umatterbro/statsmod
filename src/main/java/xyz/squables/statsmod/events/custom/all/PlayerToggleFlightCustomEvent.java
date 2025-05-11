package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerTakeLecternBookCustomEvent extends CustomEvent<PlayerTakeLecternBookEvent> {
    public PlayerTakeLecternBookCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerTakeLecternBookEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
