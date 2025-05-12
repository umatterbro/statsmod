package xyz.squables.statsmod.question.options.variables.types.dependent;

import org.apache.commons.lang3.NotImplementedException;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.variables.VariableOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DependentStringOptions extends DependentVariableOptions<String> {
    protected String variableName;
    protected String[] answerOptions;

    private void initialize(String variableName, String[] answerOptions) {
        this.variableName = variableName;
        this.answerOptions = answerOptions;
    }

    public String generateRandom() {
        return this.answerOptions[Util.generateRandomInt(0, this.answerOptions.length)];
    }

    public DependentStringOptions(String variableName) {
        super(variableName);
        initialize(variableName, new String[] {});
    }

    public DependentStringOptions(String variableName, String[] answerOptions) {
        super(variableName);
        initialize(variableName, answerOptions);
    }

    @Override
    public List<String> generateFrom(Object... input) {
        throw new NotImplementedException("uhhh nah");
    }

    @Override
    public List<String> generateAmount(int amount) {
        List<String> opts = new ArrayList<>();

        for(int i = 0; i < amount; i++) {
            while(true) {
                int j = Util.generateRandomInt(0, this.answerOptions.length);
                if(opts.contains(this.answerOptions[j])) continue;
                opts.add(this.answerOptions[j]);
                break;
            }
        }

        return opts;
    }
}
