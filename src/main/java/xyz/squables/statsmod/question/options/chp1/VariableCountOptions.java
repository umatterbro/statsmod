package xyz.squables.statsmod.question.options.chp1;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.QuestionOptions;
import xyz.squables.statsmod.question.options.variables.VariableType;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.options.variables.types.StringOptions;
import xyz.squables.statsmod.question.options.variables.types.dependent.DependentIntOptions;
import xyz.squables.statsmod.question.types.QuestionType;

import java.util.ArrayList;
import java.util.List;

// reference #6
// You measure the age (years), weight (pounds), and marital status (single, married, divorced, or widowed)
// of 1400 women. How many variables did you measure?

public class VariableCountOptions extends QuestionOptions {
    protected IntOptions variableCount = new IntOptions("Variable count", 3, 6);

    public VariableCountOptions() {
        super(QuestionType.VARIABLECOUNT);
    }

    @Override
    public <T> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.INT) {
            int vc = variableCount.generateRandom();
            DependentIntOptions ans = new DependentIntOptions("Answers", vc);
            Bukkit.getConsoleSender().sendMessage("got answer " + vc);

            List<Integer> fakeAnswers = ans.generateFrom(-vc, Util.generateRandomInt(-4, -2), Util.generateRandomInt(1, 3), vc);
            List<T> allAnswers = new ArrayList<>();

            for(int i : fakeAnswers) {
                allAnswers.add(tClass.cast(i));
            }

            T vcc = tClass.cast(vc);
            allAnswers.add(Util.generateRandomInt(0, fakeAnswers.size()), vcc);
            return new Answers<>(allAnswers, vcc);
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
