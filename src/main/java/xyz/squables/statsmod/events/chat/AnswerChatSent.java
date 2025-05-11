package xyz.squables.statsmod.events.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import xyz.squables.statsmod.Statsmod;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.result.PlayerResult;

public class AnswerChatSent implements Listener {
    @EventHandler
    public void onAnswerChatSend(PlayerCommandPreprocessEvent e) {
        var pq = Statsmod.getPq();
        Player p = e.getPlayer();
        if(!e.getMessage().startsWith("/answer")) return;
        e.setCancelled(true);

        String[] args = e.getMessage().split(" ");
        if(args.length == 1) return;

        String ans = args[1];
        Question<?> trueAns = pq.getQuestion(p.getName());

        if(!pq.isPlayerOccupied(p.getName())) return;

        pq.clearMap(p.getName());
        if(ans.equals(trueAns.getAnswers().getCorrectAnswer().toString())) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYAY&r That's correct!"));
            PlayerResult.getRandomGood().executeOn(p);
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lOOF&r That's incorrect"));
            PlayerResult.getRandomBad().executeOn(p);
        }
    }
}
