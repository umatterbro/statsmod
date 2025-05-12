package xyz.squables.statsmod.question.options;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.variables.OperationType;
import xyz.squables.statsmod.question.options.variables.VariableType;
import xyz.squables.statsmod.question.options.variables.types.DoubleOptions;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;

import java.util.ArrayList;
import java.util.List;

public class EventProbOptions extends QuestionOptions {
    protected DoubleOptions cs = new DoubleOptions("Chance Success", .35D, 1D, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, 5);
    protected IntOptions tc = new IntOptions("Trial Count", 5, 12, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    protected IntOptions st = new IntOptions("Successful Trials", 1, 3, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);

    public EventProbOptions() {
        super(QuestionType.EVENTPROB);
    }

    public double getChance() {
        return cs.getValue();
    }

    public int getTrialCount() {
        return tc.getValue();
    }

    public int getSuccessfulTrialReq() {
        return st.getValue();
    }

    private double calc(double cs, double tc, double st) {
        return ((tc/st) * (Math.pow(cs, st) * Math.pow((1-cs), (tc-st))));
    }

    private int decimalPlace = 5;

    @Override
    public <T> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.DOUBLE) {
            double cs = this.getChance();
            double tc = this.getTrialCount();
            double st = this.getSuccessfulTrialReq();

            double ans = Util.roundToN(calc(cs, tc, st), decimalPlace);
            Bukkit.getConsoleSender().sendMessage("got " + ans + " from chance=" + cs + ", tc=" + tc + ", st=" + st);

            List<T> allAnswers = new ArrayList<>();

            for(int i = 0; i < 4; i++) {
                double newCs = this.cs.generateRandom();
                double newTc = this.tc.generateRandom();
                double newSt = this.st.generateRandom();
                allAnswers.add(tClass.cast(Util.roundToN(calc(newCs, newTc, newSt), decimalPlace)));
            }

            allAnswers.add(Util.generateRandomInt(0, allAnswers.size() - 1), tClass.cast(ans));
            return new Answers<>(allAnswers, tClass.cast(ans));
        } else {
            throw new NotImplementedException("nope");
        }
    }
}
