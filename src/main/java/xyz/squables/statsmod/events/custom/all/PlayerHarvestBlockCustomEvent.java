package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerFishEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerFishCustomEvent extends CustomEvent<PlayerFishEvent> {
    public PlayerFishCustomEvent() {
        super(0.08);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerFishEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
