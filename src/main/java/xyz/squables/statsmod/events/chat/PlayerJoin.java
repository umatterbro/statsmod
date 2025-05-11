package xyz.squables.statsmod.events.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.squables.statsmod.PlayerQuestions;
import xyz.squables.statsmod.Statsmod;
import xyz.squables.statsmod.result.PlayerResult;

public class PlayerJoin implements Listener {
    private final PlayerQuestions pq = Statsmod.getPq();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String pn = e.getPlayer().getName();
        if(pq.isPlayerOccupied(pn)) pq.getQuestion(pn).send(e.getPlayer(), true);
    }
}
