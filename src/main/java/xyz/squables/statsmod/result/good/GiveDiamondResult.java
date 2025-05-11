package xyz.squables.statsmod.result.good;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.PlayerResult;

public class GiveDiamondResult extends PlayerResult {
    @Override
    public void executeOn(Player p) {
        p.getInventory().addItem(new ItemStack(Material.DIAMOND, Util.generateRandomInt(1, 3)));
    }
}
