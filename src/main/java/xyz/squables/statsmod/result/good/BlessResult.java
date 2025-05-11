package xyz.squables.statsmod.result.good;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.PlayerResult;

public class BlessResult extends PlayerResult {
    private final PotionEffectType[] goodPotions = new PotionEffectType[] {
            PotionEffectType.HASTE,
            PotionEffectType.SPEED,
            PotionEffectType.ABSORPTION,
            PotionEffectType.HEALTH_BOOST,
            PotionEffectType.INVISIBILITY,
            PotionEffectType.STRENGTH,
            PotionEffectType.REGENERATION,
            PotionEffectType.RESISTANCE,
            PotionEffectType.JUMP_BOOST,
    };

    @Override
    public void executeOn(Player p) {
        p.addPotionEffect(new PotionEffect(this.goodPotions[Util.generateRandomInt(0, this.goodPotions.length-1)], Util.generateRandomInt(30, 180)*20, Util.generateRandomInt(0, 3)));
    }
}
