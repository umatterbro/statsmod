package xyz.squables.statsmod.question.options.variables.types;

import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.variables.OperationType;
import xyz.squables.statsmod.question.options.variables.VariableOptions;

public class DoubleOptions extends VariableOptions<Double> {
    protected double min;
    protected double max;

    protected boolean useMin = false;
    protected boolean useMax = false;

    protected OperationType minOperationType;
    protected OperationType maxOperationType;

    protected int roundTo = 3;

    private void initialize(double min, double max, boolean useMin, boolean useMax, OperationType minOperationType, OperationType maxOperationType, int roundTo) {
        this.min = min;
        this.max = max;

        this.useMin = useMin;
        this.useMax = useMax;

        this.minOperationType = minOperationType;
        this.maxOperationType = maxOperationType;

        this.value = this.generateRandom();
        this.roundTo = 3;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    @Override
    public Double getValue() {
        return Util.roundToN(this.value, this.roundTo);
    }

    public double generateRandom() {
        double min = 0;
        double max = 1000;

        if(this.useMin) min = this.min;
        if(this.useMax) max = this.max;

        return Util.generateRandomDouble(min, max);
    }

    public DoubleOptions(String variableName, double min, double max, OperationType minOperationType, OperationType maxOperationType, int roundTo) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, maxOperationType, roundTo);
    }

    public DoubleOptions(String variableName, double min, double max, OperationType minOperationType, OperationType maxOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, maxOperationType, this.roundTo);
    }

    public DoubleOptions(String variableName, double min, double max, OperationType minOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, OperationType.GREATER_THAN_OR_EQUAL, this.roundTo);
    }

    public DoubleOptions(String variableName, double min, double max) {
        super(variableName);
        initialize(min, max, true, true, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, this.roundTo);
    }

    public DoubleOptions(String variableName, double min) {
        super(variableName);
        initialize(min, 0, true, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, this.roundTo);
    }

    public DoubleOptions(String variableName) {
        super(variableName);
        initialize(0, 0, false, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL, this.roundTo);
    }

    @Override
    public void setValue(Double value) {
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
