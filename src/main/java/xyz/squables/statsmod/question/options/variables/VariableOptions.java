package xyz.squables.statsmod.question.options.variables;

public class VariableOptions<T> {
    public String variableName;
    protected T value;

    public VariableOptions(String variableName) {
        this.variableName = variableName;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        throw new IllegalCallerException("set value being called from parent function (nono)");
    }
}
