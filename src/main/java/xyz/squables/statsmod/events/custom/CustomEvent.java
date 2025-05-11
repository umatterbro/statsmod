package xyz.squables.statsmod.events.custom;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.squables.statsmod.PlayerQuestions;
import xyz.squables.statsmod.Statsmod;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.types.Question;

public abstract class CustomEvent<T extends Cancellable> implements Listener {
    private final PlayerQuestions pq = Statsmod.getPq();

    protected double lockProbability;

    final double mul = 1;

    public CustomEvent(double lockProbability) {
        this.lockProbability = lockProbability;
    }

    @EventHandler
    public abstract void handleEvent(T e);

    protected void doLockCheck(Player p, T e) {
        if(p == null) return;
        if(p.isOp()) return;

        String pn = p.getName();
        if(pq.isPlayerOccupied(pn)) {
            e.setCancelled(true);
            return;
        }

        double rnd = Util.roundToN(Util.generateRandomDouble(0D, 1D), 3);
        if(rnd <= this.lockProbability*mul) {
            Question<?> q = Question.generateQuestion();
            pq.setQuestionAnswer(pn, q);
            q.send(p, true);
        } /*else {
            p.sendMessage("dodged b/c " + rnd + " > " + this.lockProbability + "*" + mul + " (" + this.lockProbability*mul + ") for " + this.getClass().getTypeName().split("[.]")[this.getClass().getTypeName().split("[.]").length-1]);
        }*/
    }

    protected void doLightCheck(Player p, T e) {
        if(p == null) return;
        if(p.isOp()) return;

        String pn = p.getName();
        if(pq.isPlayerOccupied(pn)) e.setCancelled(true);
    }
}
