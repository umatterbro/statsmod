package xyz.squables.statsmod.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import xyz.squables.statsmod.Statsmod;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistrar {
    private final Statsmod mod = Statsmod.getInstance();
    private final Map<String, CommandExecutor> ceMap = new HashMap<>();

    public CommandRegistrar(Command... cmds) {
        int i = 0;
        int j = 0;
        for(var c : cmds) {
            mod.getCommand(c.name).setExecutor(c.exec);
            mod.getCommand(c.name).setTabCompleter(c.tc);
        }

        Bukkit.getConsoleSender().sendMessage("registered " + cmds.length + " commands");
    }
}
