package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerEditBookCustomEvent extends CustomEvent<PlayerEditBookEvent> {
    public PlayerEditBookCustomEvent() {
        super(0.8);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerEditBookEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
