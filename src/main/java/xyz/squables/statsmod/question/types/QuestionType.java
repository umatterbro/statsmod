package xyz.squables.statsmod.question.types;

import xyz.squables.statsmod.question.options.variables.VariableType;

public enum QuestionType {
    InverseT(VariableType.DOUBLE),
    InverseZ(VariableType.DOUBLE),
    EventProb(VariableType.DOUBLE);

    public final VariableType type;
    QuestionType(VariableType type) {
        this.type = type;
    }
}
