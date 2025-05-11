package xyz.squables.statsmod.events.custom.all;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import xyz.squables.statsmod.events.custom.CustomEvent;

public class BlockDispenseArmorCustomEvent extends CustomEvent<BlockDispenseArmorEvent> {
    public BlockDispenseArmorCustomEvent() {
        super(0.25);
    }

    @Override
    @EventHandler
    public void handleEvent(BlockDispenseArmorEvent e) {
        if(!(e.getTargetEntity() instanceof Player p)) return;
        this.doLockCheck(p, e);
    }
}
