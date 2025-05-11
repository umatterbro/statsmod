package xyz.squables.statsmod.cmd.tc;

import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import xyz.squables.statsmod.Statsmod;

import java.util.HashMap;
import java.util.Map;

public class TabCompleteRegistrar {
    private final Statsmod mod = Statsmod.getInstance();
    private final Map<String, TabCompleter> ceMap = new HashMap<>();

    public TabCompleteRegistrar(Map<String, TabCompleter> tcelms) {
        for(var c : tcelms.entrySet()) {
            mod.getCommand(c.getKey()).setTabCompleter(c.getValue());
        }

        Bukkit.getConsoleSender().sendMessage("registered " + tcelms.size() + " tab completers");
    }
}
