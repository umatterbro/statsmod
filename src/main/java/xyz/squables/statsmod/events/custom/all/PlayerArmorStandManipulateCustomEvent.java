package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PigZombieAngerEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerAnimationCustomEvent extends CustomEvent<PlayerAnimationEvent> {
    public PlayerAnimationCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerAnimationEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
