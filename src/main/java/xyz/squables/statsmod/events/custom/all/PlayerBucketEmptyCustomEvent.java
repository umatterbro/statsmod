package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerBucketEmptyCustomEvent extends CustomEvent<PlayerBucketEmptyEvent> {
    public PlayerBucketEmptyCustomEvent() {
        super(0.2);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
