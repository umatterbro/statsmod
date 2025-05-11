package xyz.squables.statsmod.question.options.variables.types;

import javax.annotation.Nullable;
import java.util.Optional;

public class FloatOptions extends VariableOptions<Float> {
    protected float min;
    protected float max;

    protected boolean useMin = false;
    protected boolean useMax = false;

    protected OperationType minOperationType;
    protected OperationType maxOperationType;

    private void initialize(float min, float max, boolean useMin, boolean useMax, OperationType minOperationType, OperationType maxOperationType) {
        this.min = min;
        this.max = max;

        this.useMin = useMin;
        this.useMax = useMax;

        this.minOperationType = minOperationType;
        this.maxOperationType = maxOperationType;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }

    public FloatOptions(String variableName, float min, float max, OperationType minOperationType, OperationType maxOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, maxOperationType);
    }

    public FloatOptions(String variableName, float min, float max, OperationType minOperationType) {
        super(variableName);
        initialize(min, max, true, true, minOperationType, OperationType.GREATER_THAN_OR_EQUAL);
    }

    public FloatOptions(String variableName, float min, float max) {
        super(variableName);
        initialize(min, max, true, true, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    }

    public FloatOptions(String variableName, float min) {
        super(variableName);
        initialize(min, 0, true, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    }

    public FloatOptions(String variableName) {
        super(variableName);
        initialize(0, 0, false, false, OperationType.LESS_THAN_OR_EQUAL, OperationType.GREATER_THAN_OR_EQUAL);
    }

    @Override
    public void setValue(Float value) {
        if(this.useMin) {
            if(value < this.min) throw new IllegalArgumentException("value " + value + " is " + this.minOperationType.label + " " + this.min);
        }

        if(this.useMax) {
            if(value > this.max) throw new IllegalArgumentException("value " + value + " is " + this.maxOperationType.label + " " + this.max);
        }

        this.value = value;
    }
}
