package xyz.squables.statsmod.question.options.chapters.chp3;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.answer.chapters.chp2.PercentileOfPopulationAnswers;
import xyz.squables.statsmod.question.options.QuestionOptions;
import xyz.squables.statsmod.question.options.variables.VariableType;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.options.variables.types.dependent.DependentIntOptions;
import xyz.squables.statsmod.question.types.QuestionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// reference #42
/*
A study gathers data on the outside temperature during the winter, in degrees Fahrenheit, and the amount of
natural gas a household consumes, in cubic feet per day. Call the temperature x and gas consumption y. The
house is heated with gas, so x helps explain y. The least-squares regression line for predicting y from x is
y=1344-19x. On a day when the temperature is 20F, the regression line predicts that gas used will be
about
    a. 1724 cubic feet.
    b. 1383 cubic feet.
    c. 1325 cubic feet.
    d. 964 cubic feet.
    e. none of these.*/
public class LSLRPredictOptions extends QuestionOptions {
    public LSLRPredictOptions() {
        super(QuestionType.LSLRPREDICT);
    }

    protected final IntOptions slope = new IntOptions("Slope", 25, 50);
    protected final IntOptions yint = new IntOptions("Y Intercept", -12, 24);
    protected final IntOptions xval = new IntOptions("X Value", 5, 10);

    protected int calc(int slope, int yint, int xval) {
        return slope+(yint*xval);
    }

    public int getSlope() { return slope.getValue(); }
    public int getYInt() { return yint.getValue(); }
    public int getXVal() { return xval.getValue(); }

    @Override
    public <T> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.INT) {
            int sl = this.getSlope();
            int yi = this.getYInt();
            int xv = this.getXVal();
            int val = calc(sl, yi, xv);

            List<T> answers = new ArrayList<>();
            List<Integer> fakeAnswers = new DependentIntOptions("Fake Answers", val).generateFrom(
                    sl-(yi*xv),
                    sl*(yi+xv),
                    Util.generateRandomInt(xv, sl),
                    Util.generateRandomInt(xv, sl)
            );
            for(Integer i : fakeAnswers) answers.add(tClass.cast(i));

            Bukkit.getConsoleSender().sendMessage("got answer: " + val);

            T cc = tClass.cast(val);
            answers.addFirst(cc);
            Collections.shuffle(answers);
            return new Answers<>(answers, cc);
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
