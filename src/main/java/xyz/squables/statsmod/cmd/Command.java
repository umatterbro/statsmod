package xyz.squables.statsmod.cmd;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public class Command {
    public String name;
    public CommandExecutor exec;
    public TabCompleter tc;

    public Command(String name, CommandExecutor exec, TabCompleter tc) {
        this.name = name;
        this.exec = exec;
        this.tc = tc;
    }
}
