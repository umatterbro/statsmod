package xyz.squables.statsmod.question.options.chapters.chp2;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.QuestionOptions;
import xyz.squables.statsmod.question.options.variables.VariableType;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.question.answer.chapters.chp2.PercentileOfPopulationAnswers;

import java.util.*;

// reference #2
/*
The 35th percentile of a population is the number x such that
    a. 35% of the population scores are above x.
    b. 65% of the population scores are above x.
    c. 35% of the population scores equal x.
    d. x is 35% of the population median.
    e. x is 35% of the population mean.*/
public class PercentileOfPopulationOptions extends QuestionOptions {
    public PercentileOfPopulationOptions() {
        super(QuestionType.VARIABLECOUNT);
    }

    protected IntOptions percentile = new IntOptions("Percentile", 25, 75);
    protected String[] answerTemplates = new String[]{
            "%d percent of the population scores are above x",
            "%d percent of the population scores equal x",
            "x is %d percent of the population median",
            "x is %d percent of the population mean",
    };

    @Override
    public <T> PercentileOfPopulationAnswers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.STRING) {
            int perc = percentile.generateRandom();
            int rPerc = Math.abs(100-perc);

            List<T> answers = new ArrayList<>();

            for(String s : answerTemplates) {
                answers.add(tClass.cast(String.format(s, perc)));
            }

            String correct = rPerc + " percent of the population scores are above x";
            Collections.shuffle(answers);
            Bukkit.getConsoleSender().sendMessage("got answer: " + correct);

            T cc = tClass.cast(correct);
            answers.add(Util.generateRandomInt(0, answers.size()), cc);
            return new PercentileOfPopulationAnswers<>(answers, cc, perc);
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
