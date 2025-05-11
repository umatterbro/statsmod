package xyz.squables.statsmod.question.types;

import org.bukkit.entity.Player;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.QuestionOptions;
import xyz.squables.statsmod.question.options.variables.VariableType;

import java.util.Random;

public abstract class Question<T extends QuestionOptions> {
    public QuestionType type;
    protected T options;
    protected Answers answers;
    protected String template;

    public Question(QuestionType type, T opts, String template) {
        this.type = type;
        this.options = opts;
        this.template = template;

        if(this.type.type == VariableType.DOUBLE) {
            this.answers = opts.generateAnswers(this.type, Double.class);
        }
    }

    public Question(QuestionType type, T opts) {
        this.type = type;
        this.options = opts;

        if(this.type.type == VariableType.DOUBLE) {
            this.answers = opts.generateAnswers(this.type, Double.class);
        }
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public T getOptions() {
        return this.options;
    }

    public String getCorrectAnswer() {
        return this.answers.getCorrectAnswer().toString();
    }

    public Answers getAnswers() {
        return this.answers;
    }

    public String formatTemplate(Object... args) {
        return String.format(this.template, args);
    }

    public abstract void send(Player p);

    public static Question generateQuestion() {
        return _generateQuestion(QuestionType.values()[new Random().nextInt(QuestionType.values().length)]);
    }

    private static Question _generateQuestion(QuestionType qt) {
        switch (qt) {
            case InverseT: return new InverseTQuestion();
            case InverseZ: return new InverseZQuestion();
            case EventProb: return new EventProbQuestion();
        }

        return null;
    }
}
