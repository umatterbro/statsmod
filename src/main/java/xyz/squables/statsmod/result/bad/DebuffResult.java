package xyz.squables.statsmod.result.bad;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.PlayerResult;

public class DebuffResult extends PlayerResult {
    private final PotionEffectType[] badPotions = new PotionEffectType[] {
            PotionEffectType.BLINDNESS,
            PotionEffectType.HUNGER,
            PotionEffectType.LEVITATION,
            PotionEffectType.MINING_FATIGUE,
            PotionEffectType.POISON,
            PotionEffectType.SLOWNESS,
            PotionEffectType.UNLUCK,
            PotionEffectType.WEAKNESS
    };

    @Override
    public void executeOn(Player p) {
        p.addPotionEffect(new PotionEffect(this.badPotions[Util.generateRandomInt(0, this.badPotions.length)], Util.generateRandomInt(30, 180)*20, Util.generateRandomInt(0, 3)));
    }
}
