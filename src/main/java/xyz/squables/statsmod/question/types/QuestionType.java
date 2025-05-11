package xyz.squables.statsmod.question.types;

import xyz.squables.statsmod.question.options.variables.VariableType;

public enum QuestionType {
    INVERSET(VariableType.DOUBLE),
    INVERSEZ(VariableType.DOUBLE),
    EVENTPROB(VariableType.DOUBLE);

    public final VariableType type;
    QuestionType(VariableType type) {
        this.type = type;
    }
}
