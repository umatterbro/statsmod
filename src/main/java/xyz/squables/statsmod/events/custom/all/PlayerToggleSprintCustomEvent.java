package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerToggleSprintCustomEvent extends CustomEvent<PlayerToggleSprintEvent> {
    public PlayerToggleSprintCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerToggleSprintEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
