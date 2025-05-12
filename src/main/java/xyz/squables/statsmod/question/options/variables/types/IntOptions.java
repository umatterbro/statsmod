package xyz.squables.statsmod.question.options.variables.types;

import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.variables.OperationType;
import xyz.squables.statsmod.question.options.variables.VariableOptions;

public class IntOptions extends VariableOptions<Integer> {
    protected int min;
    protected int max;

    protected boolean useMin = false;
    protected boolean useMax = false;

    protected OperationType minOperationType;
    protected OperationType maxOperationType;

    protected Integer[] presetOptions = null;

    private void initialize(int min, int max, boolean useMin, boolean useMax, OperationType minOperationType, OperationType maxOperationType, Integer[] presetOptions) {
        this.min = min;
        this.max = max;

        this.useMin = useMin;
        this.useMax = useMax;

        this.minOperationType = minOperationType;
        this.maxOperationType = maxOperationType;

        this.presetOptions = presetOptions;

        this.value = this.generateRandom();
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public IntOptions(String variableName, Integer[] presetOptions) {
        super(variableName);
        initialize(0, 0, false, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, presetOptions);
    }

    public IntOptions(String variableName, int min, int max, OperationType minOperationType, OperationType maxOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, maxOperationType, null);
    }

    public IntOptions(String variableName, int min, int max, OperationType minOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, OperationType.GREATER_THAN_OR_EQUAL, null);
    }

    public IntOptions(String variableName, int min, int max) {
        super(variableName);
        initialize(min, max, true, true, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, null);
    }

    public IntOptions(String variableName, int min) {
        super(variableName);
        initialize(min, 0, true, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, null);
    }

    public IntOptions(String variableName) {
        super(variableName);
        initialize(0, 0, false, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, null);
    }

    public Integer generateRandom() {
        if(this.presetOptions != null) return this.presetOptions[Util.generateRandomInt(0, this.presetOptions.length)];

        int min = 0;
        int max = 1000;

        if(this.useMin) min = this.min;
        if(this.useMax) max = this.max;

        return Util.generateRandomInt(min, max);
    }

    @Override
    public void setValue(Integer value) {
        if(this.useMin) {
            switch(this.minOperationType) {
                case OperationType.LESS_THAN: if(value < this.min) throw new IllegalArgumentException("value " + value + " is " + this.minOperationType.label + " " + this.min); break;
                case OperationType.LESS_THAN_OR_EQUAL: if(value <= this.min) throw new IllegalArgumentException("value " + value + " is " + this.minOperationType.label + " " + this.min); break;
                case OperationType.NONE: break;
                default: throw new IllegalArgumentException("illegal operation type " + this.minOperationType.label);
            }
        }

        if(this.useMax) {
            switch(this.maxOperationType) {
                case OperationType.GREATER_THAN: if(value > this.max) throw new IllegalArgumentException("value " + value + " is " + this.maxOperationType.label + " " + this.max); break;
                case OperationType.GREATER_THAN_OR_EQUAL: if(value >= this.max) throw new IllegalArgumentException("value " + value + " is " + this.maxOperationType.label + " " + this.max); break;
                case OperationType.NONE: break;
                default: throw new IllegalArgumentException("illegal operation type " + this.maxOperationType.label);
            }
        }

        this.value = value;
    }
}
