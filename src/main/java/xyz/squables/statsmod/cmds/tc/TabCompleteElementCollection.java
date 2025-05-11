package xyz.squables.statsmod.cmds.tc;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteElementCollection {
    protected List<TabCompleteElement> children;

    public TabCompleteElementCollection(List<TabCompleteElement> children) {
        this.children = children;
    }

    public TabCompleteElementCollection next(String key) {
        for(var tc : this.children) {
            if(tc.getTrigger().equals(key)) return tc.getChildren();
        }

        return null;
    }

    public List<TabCompleteElement> getChildren() {
        return this.children;
    }

    public List<String> getTriggers(String filter, boolean op) {
        List<String> triggers = new ArrayList<>();
        for(var tc : this.children) {
            if(tc.requiresOp() && !op) continue;
            String trigger = tc.getTrigger();
            if(!filter.isBlank()) {
                if(!trigger.startsWith(filter)) continue;
                triggers.add(trigger);
            } else triggers.add(trigger);
        }
        return triggers;
    }
}
