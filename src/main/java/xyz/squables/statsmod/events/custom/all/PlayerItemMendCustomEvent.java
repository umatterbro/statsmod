package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class PlayerItemDamageCustomEvent extends CustomEvent<PlayerItemConsumeEvent> {
    public PlayerItemDamageCustomEvent() {
        super(0);
    }

    @Override
    @EventHandler
    public void handleEvent(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        this.doLightCheck(p, e);
    }
}
