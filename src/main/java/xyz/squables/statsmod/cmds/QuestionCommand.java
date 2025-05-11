package xyz.squables.statsmod.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.squables.statsmod.PlayerQuestions;
import xyz.squables.statsmod.Statsmod;
import xyz.squables.statsmod.question.types.Question;

public class QuestionCommand implements CommandExecutor {
    private final PlayerQuestions pq = Statsmod.getPq();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String @NotNull [] args) {
        if(!(sender instanceof Player)) return true;
        Player p = ((Player) sender);

        if(pq.isPlayerOccupied(p.getName())) {
            p.sendMessage("First finish the question you're currently on");
            return true;
        }

        Question q = Question.generateQuestion();
        pq.setQuestionAnswer(p.getName(), q.getAnswers().getCorrectAnswer().toString());
        q.send(p);
        return true;
    }
}
