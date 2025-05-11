package xyz.squables.statsmod.question.options;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.variables.types.DoubleOptions;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.options.variables.OperationType;
import xyz.squables.statsmod.question.options.variables.VariableType;

import org.apache.commons.math3.distribution.TDistribution;

import java.util.ArrayList;
import java.util.List;

public class InverseTOptions extends QuestionOptions {
    protected DoubleOptions area = new DoubleOptions("Area", 0D, 1D, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    protected IntOptions df = new IntOptions("Degrees of freedom", 0, 100, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);

    public InverseTOptions() {
        super(QuestionType.InverseT);
    }

    public double getArea() {
        return area.getValue();
    }

    public int getDf() {
        return df.getValue();
    }

    @Override
    public <T extends Number> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.DOUBLE) {
            double area = this.getArea();
            int df = this.getDf();

            TDistribution td = new TDistribution(df);
            double tscore = Util.roundToN(td.inverseCumulativeProbability(area), 3);
            Bukkit.getConsoleSender().sendMessage("got " + tscore + " from area=" + area + " and df=" + df);

            List<T> allAnswers = new ArrayList<>();

            for(int i = 0; i < 4; i++) {
                TDistribution ntd = new TDistribution(this.df.generateRandom());
                allAnswers.add(tClass.cast(Util.roundToN(ntd.inverseCumulativeProbability(this.area.generateRandom()), 3)));
            }

            allAnswers.add(Util.generateRandomInt(0, allAnswers.size() - 1), tClass.cast(tscore));
            return new Answers<>(allAnswers, tClass.cast(tscore));
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
