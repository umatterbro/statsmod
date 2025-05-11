package xyz.squables.statsmod.question.options;

import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.question.answer.Answers;

public abstract class QuestionOptions {
    protected QuestionType type;

    public QuestionOptions(QuestionType type) {
        this.type = type;
    }

    public abstract <T extends Number> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass);
}
