package xyz.squables.statsmod.question.options;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.variables.types.DoubleOptions;
import xyz.squables.statsmod.question.options.variables.OperationType;
import xyz.squables.statsmod.question.options.variables.VariableType;

import java.util.ArrayList;
import java.util.List;

public class InverseZOptions extends QuestionOptions {
    protected DoubleOptions area = new DoubleOptions("Area", 0D, 1D, OperationType.LESS_THAN, OperationType.GREATER_THAN);
    protected DoubleOptions mean = new DoubleOptions("Mean", 30D, 100D, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    protected DoubleOptions sd = new DoubleOptions("Standard Deviation", 5D, 10D, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);

    public InverseZOptions() {
        super(QuestionType.INVERSEZ);
    }

    public double getArea() {
        return area.getValue();
    }

    public double getMean() {
        return mean.getValue();
    }

    public double getSD() {
        return sd.getValue();
    }

    @Override
    public <T> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.DOUBLE) {
            double area = this.getArea();
            double mean = this.getMean();
            double sd = this.getSD();

            NormalDistribution nd = new NormalDistribution(mean, sd);
            double zscore = Util.roundToN(nd.inverseCumulativeProbability(area), 3);
            Bukkit.getConsoleSender().sendMessage("got " + zscore + " from area=" + area + ", mean=" + mean + ", sd=" + sd);

            List<T> allAnswers = new ArrayList<>();

            for(int i = 0; i < 4; i++) {
                NormalDistribution ntd = new NormalDistribution(this.mean.generateRandom(), this.sd.generateRandom());
                allAnswers.add(tClass.cast(Util.roundToN(ntd.inverseCumulativeProbability(this.area.generateRandom()), 3)));
            }

            allAnswers.add(Util.generateRandomInt(0, allAnswers.size() - 1), tClass.cast(zscore));
            return new Answers<>(allAnswers, tClass.cast(zscore));
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
