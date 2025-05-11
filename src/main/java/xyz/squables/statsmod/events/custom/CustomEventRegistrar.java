package xyz.squables.statsmod.events.custom;

import xyz.squables.statsmod.Statsmod;

public class CustomEventRegistrar {
    private final Statsmod mod = Statsmod.getInstance();
    public CustomEventRegistrar(CustomEvent<?>... events) {
        int s = 0;
        int f = 0;
        for(var e : events) {
            try {
                mod.getServer().getPluginManager().registerEvents(e, mod);
                s++;
            } catch(Exception ex) {
                f++;
            }
        }

        mod.getServer().getConsoleSender().sendMessage("registered " + s + " custom events, failed to register " + f + " others");
    }
}
