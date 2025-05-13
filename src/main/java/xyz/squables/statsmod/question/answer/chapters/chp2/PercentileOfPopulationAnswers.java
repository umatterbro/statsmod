package xyz.squables.statsmod.question.answer.chapters.chp2;

import xyz.squables.statsmod.question.answer.Answers;

import java.util.List;

public class PercentileOfPopulationAnswers<T> extends Answers<T> {
    protected int percentile;
    public PercentileOfPopulationAnswers(List<T> answers, T correctAnswer, int percentile) {
        super(answers, correctAnswer);
        this.percentile = percentile;
    }

    public int getPercentile() { return percentile; }
}
