package xyz.squables.statsmod.cmds;

import org.bukkit.command.CommandExecutor;

public class Command {
    public String name;
    public CommandExecutor exec;

    public Command(String name, CommandExecutor exec) {
        this.name = name;
        this.exec = exec;
    }
}
