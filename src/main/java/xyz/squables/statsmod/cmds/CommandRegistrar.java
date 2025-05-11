package xyz.squables.statsmod.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import xyz.squables.statsmod.Statsmod;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistrar {
    private final Statsmod mod = Statsmod.getInstance();
    private final Map<String, CommandExecutor> ceMap = new HashMap<>();

    public CommandRegistrar(Command... cmds) {
        for(var c : cmds) {
            mod.getCommand(c.name).setExecutor(c.exec);
        }

        Bukkit.getConsoleSender().sendMessage("registered " + cmds.length + " commands");
    }
}
