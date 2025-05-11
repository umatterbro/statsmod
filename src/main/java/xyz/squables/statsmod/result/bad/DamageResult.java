package xyz.squables.statsmod.result.bad;

import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.PlayerResult;

public class DamageResult extends PlayerResult {
    @Override
    public void executeOn(Player p) {
        p.damage(Util.generateRandomDouble(2, 5));
    }
}
