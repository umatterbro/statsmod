package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerBucketEntityCustomEvent extends CustomEvent<PlayerBucketEntityEvent> {
    public PlayerBucketEntityCustomEvent() {
        super(0.5);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerBucketEntityEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
