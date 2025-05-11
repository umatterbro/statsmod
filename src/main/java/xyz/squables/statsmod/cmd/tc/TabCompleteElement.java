package xyz.squables.statsmod.cmd.tc;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteElement {
    private String trigger;
    private boolean requiresOp;
    private boolean requiresPlayer;
    protected TabCompleteElementCollection children;

    public TabCompleteElement(String trigger, boolean requiresOp, boolean requiresPlayer, TabCompleteElementCollection children) {
        this.trigger = trigger;
        this.requiresOp = requiresOp;
        this.requiresPlayer = requiresPlayer;
        this.children = children;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public boolean requiresOp() {
        return this.requiresOp;
    }

    public boolean requiresPlayer() {
        return this.requiresPlayer;
    }

    public TabCompleteElementCollection getChildren() {
        return this.children;
    }

    public static TabCompleteElement[] generateBlanks(List<String> values, boolean requiresOp, boolean requiresPlayer) {
        List<TabCompleteElement> tcevs = new ArrayList<>();
        for(String v : values) tcevs.add(new TabCompleteElement(v, requiresOp, requiresPlayer, null));
        return tcevs.toArray(new TabCompleteElement[0]);
    }

    public static TabCompleteElement[] generateDupes(List<String> values, boolean requiresOp, boolean requiresPlayer, TabCompleteElementCollection children) {
        List<TabCompleteElement> tcevs = new ArrayList<>();
        for(String v : values) tcevs.add(new TabCompleteElement(v, requiresOp, requiresPlayer, children));
        return tcevs.toArray(new TabCompleteElement[0]);
    }
}
