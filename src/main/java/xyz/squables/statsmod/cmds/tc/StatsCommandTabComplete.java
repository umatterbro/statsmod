package xyz.squables.statsmod.cmds.tc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.squables.statsmod.result.PlayerResult;

import java.util.ArrayList;
import java.util.List;

public class StatsCommandTabComplete implements TabCompleter {
    TabCompleteElementCollection completes = new TabCompleteElementCollection(List.of(
            new TabCompleteElement("debug", true, new TabCompleteElementCollection(List.of(
                    TabCompleteElement.generateBlanks(PlayerResult.getAllNames(), true)
            )))
    ));
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        String cursor;
        TabCompleteElementCollection elms = completes;
        for(int i = 1; i < args.length; i++) {
            cursor = args[i-1];
            if(elms.next(cursor) == null) return List.of();
            elms = elms.next(cursor);
        }

        return elms.getTriggers(args[args.length-1], sender.isOp());
    }
}
