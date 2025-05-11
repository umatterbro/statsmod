package xyz.squables.statsmod.question.options.variables;

public enum OperationType {
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    EQUAL("="),
    NOT_EQUAL("/="),
    NONE("n/a");

    public final String label;
    OperationType(String label) {
        this.label = label;
    }
}
