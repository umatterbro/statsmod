package xyz.squables.statsmod.cmds.tc;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteElement {
    private String trigger;
    private boolean requiresOp;
    protected TabCompleteElementCollection children;

    public TabCompleteElement(String trigger, boolean requiresOp, TabCompleteElementCollection children) {
        this.trigger = trigger;
        this.requiresOp = requiresOp;
        this.children = children;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public boolean requiresOp() {
        return this.requiresOp;
    }

    public TabCompleteElementCollection getChildren() {
        return this.children;
    }

    public static TabCompleteElement[] generateBlanks(List<String> values, boolean requiresOp) {
        List<TabCompleteElement> tcevs = new ArrayList<>();
        for(String v : values) tcevs.add(new TabCompleteElement(v, requiresOp, null));
        return tcevs.toArray(new TabCompleteElement[0]);
    }
}
