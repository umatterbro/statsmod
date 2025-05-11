package xyz.squables.statsmod.result;

import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.bad.DamageResult;
import xyz.squables.statsmod.result.good.GiveDiamondResult;

public abstract class PlayerResult {
    public abstract void executeOn(Player p);

    private static final PlayerResult[] _goodPrs = new PlayerResult[] {
            new GiveDiamondResult()
    };

    private static final PlayerResult[] _badPrs = new PlayerResult[] {
            new DamageResult()
    };

    public static PlayerResult getRandomGood() {
        return _goodPrs[Util.generateRandomInt(0, _goodPrs.length)];
    }

    public static PlayerResult getRandomBad() {
        return _badPrs[Util.generateRandomInt(0, _badPrs.length)];
    }
}
