package xyz.squables.statsmod.question.options.variables.types.dependent;

import java.util.List;

public abstract class DependentVariableOptions<T> {
    public String variableName;
    protected T value;

    public DependentVariableOptions(String variableName) {
        this.variableName = variableName;
    }

    public void setValue(T value) {
        throw new IllegalCallerException("called from parent function (nono)");
    }

    public List<T> generateFrom(Object... input) {
        throw new IllegalCallerException("called from parent function (nono)");
    }

    public List<T> generateAmount(int amount) {
        throw new IllegalCallerException("called from parent function (nono)");
    }
}
