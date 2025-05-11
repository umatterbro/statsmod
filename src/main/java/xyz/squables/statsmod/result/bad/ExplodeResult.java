package xyz.squables.statsmod.result.bad;

import org.bukkit.entity.Player;
import xyz.squables.statsmod.result.PlayerResult;

public class ExplodeResult extends PlayerResult {
    @Override
    public void executeOn(Player p) {
        p.getWorld().createExplosion(p.getLocation(), 1, false, false);
    }
}
