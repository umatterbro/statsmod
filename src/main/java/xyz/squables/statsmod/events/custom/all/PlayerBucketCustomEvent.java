package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.event.player.PlayerBucketEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerBucketCustomEvent extends CustomEvent<PlayerBucketEvent> {
    public PlayerBucketCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerBucketEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
