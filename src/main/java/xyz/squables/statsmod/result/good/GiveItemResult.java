package xyz.squables.statsmod.result.good;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.result.PlayerResult;

import java.util.Map;

class ItemAmountInterval {
    private int min;
    private int max;

    public ItemAmountInterval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generateRandom() {
        return Util.generateRandomInt(this.min, this.max);
    }
}

public class GiveItemResult extends PlayerResult {
    private Map<Material, ItemAmountInterval> goodItems = Map.ofEntries(
            Map.entry(Material.NETHERITE_INGOT, new ItemAmountInterval(1, 2)),
            Map.entry(Material.DIAMOND, new ItemAmountInterval(3, 5)),
            Map.entry(Material.EMERALD, new ItemAmountInterval(4, 8)),
            Map.entry(Material.GOLD_INGOT, new ItemAmountInterval(6, 12)),
            Map.entry(Material.IRON_INGOT, new ItemAmountInterval(8, 16)),
            Map.entry(Material.COAL, new ItemAmountInterval(64, 128)),
            Map.entry(Material.TOTEM_OF_UNDYING, new ItemAmountInterval(1, 2))
    );
    @Override
    public void executeOn(Player p) {
        int i = Util.generateRandomInt(0, goodItems.size());
        int c = 0;
        Map.Entry<Material, ItemAmountInterval> selected = null;
        for(Map.Entry<Material, ItemAmountInterval> e : this.goodItems.entrySet()) {
            if(c == i) selected = e;
            c++;
        }

        p.getInventory().addItem(new ItemStack(selected.getKey(), selected.getValue().generateRandom()));
    }
}
