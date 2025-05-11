package xyz.squables.statsmod.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import xyz.squables.statsmod.Statsmod;

public class EventRegistrar {
    public EventRegistrar(Listener... listeners) {
        Statsmod mod = Statsmod.getInstance();
        for(Listener l : listeners) {
            mod.getServer().getPluginManager().registerEvents(l, mod);
        }

        Bukkit.getServer().getConsoleSender().sendMessage("registered " + listeners.length + " listeners");
    }
}
