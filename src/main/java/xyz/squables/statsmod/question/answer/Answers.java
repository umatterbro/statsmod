package xyz.squables.statsmod.question;

import java.util.List;

public class Answers<T> {
    private List<T> answers;
    private T correctAnswer;

    public Answers(List<T> answers, T correctAnswer) {
        this.answers = answers;
        this.correctAnswer = correctAnswer;

        if(!this.answers.contains(this.correctAnswer)) throw new IllegalArgumentException("Correct answer is not contained within answer options");
    }

    public List<T> getAnswerOptions() {
        return this.answers;
    }

    public boolean isAnswerCorrect(T given) {
        return given.equals(this.correctAnswer);
    }
}
