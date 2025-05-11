package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerArmorStandManipulateCustomEvent extends CustomEvent<PlayerArmorStandManipulateEvent> {
    public PlayerArmorStandManipulateCustomEvent() {
        super(0.3);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerArmorStandManipulateEvent e) {
        Player p = e.getPlayer();
        this.doLockCheck(p, e);
    }
}
