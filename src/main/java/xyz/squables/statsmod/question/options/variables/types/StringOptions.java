package xyz.squables.statsmod.question.options.variables.types;

import org.apache.commons.lang3.NotImplementedException;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.variables.VariableOptions;

public class StringOptions extends VariableOptions<String> {
    protected String variableName;
    protected String[] answerOptions;

    private void initialize(String variableName, String[] answerOptions) {
        this.variableName = variableName;
        this.answerOptions = answerOptions;
    }

    public String generateRandom() {
        return this.answerOptions[Util.generateRandomInt(0, this.answerOptions.length)];
    }

    public StringOptions(String variableName) {
        super(variableName);
        initialize(variableName, new String[] {});
    }

    public StringOptions(String variableName, String[] answerOptions) {
        super(variableName);
        initialize(variableName, answerOptions);
    }
}
