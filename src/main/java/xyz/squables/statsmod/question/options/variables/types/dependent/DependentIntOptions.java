package xyz.squables.statsmod.question.options.variables.types.dependent;

import xyz.squables.statsmod.question.options.variables.VariableOptions;

import java.util.ArrayList;
import java.util.List;

public class DependentIntOptions extends DependentVariableOptions<Integer> {
    protected int base;

    public DependentIntOptions(String variableName, int base) {
        super(variableName);
        this.variableName = variableName;
        this.base = base;
    }

    @Override
    public List<Integer> generateFrom(Object... input) {
        List<Integer> answers = new ArrayList<>();
        for(Object i : input) {
            answers.add(this.base + ((int) i));
        }
        return answers;
    }
}
