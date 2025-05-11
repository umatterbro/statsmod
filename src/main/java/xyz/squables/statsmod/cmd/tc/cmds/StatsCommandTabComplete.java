package xyz.squables.statsmod.cmd.tc.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.cmd.tc.TabCompleteElement;
import xyz.squables.statsmod.cmd.tc.TabCompleteElementCollection;
import xyz.squables.statsmod.result.PlayerResult;

import java.util.List;

public class StatsCommandTabComplete implements TabCompleter {
    TabCompleteElementCollection completes = new TabCompleteElementCollection(List.of(
            new TabCompleteElement("debug", true, false, new TabCompleteElementCollection(List.of(
                    new TabCompleteElement("result", true, false, new TabCompleteElementCollection(List.of(
                            TabCompleteElement.generateDupes(PlayerResult.getAllNames(), true, false, new TabCompleteElementCollection(List.of(
                                    TabCompleteElement.generateBlanks(Util.getAllOnlineUsernames(), true, false)
                            )))
                    ))),
                    new TabCompleteElement("question", true, false, new TabCompleteElementCollection(List.of(
                            new TabCompleteElement("get", true, true, new TabCompleteElementCollection(List.of(
                                    TabCompleteElement.generateBlanks(Util.getAllOnlineUsernames(), true, false)
                            ))),
                            new TabCompleteElement("give", true, false, new TabCompleteElementCollection(List.of(
                                    TabCompleteElement.generateDupes(Util.getAllOnlineUsernames(), true, false, new TabCompleteElementCollection(List.of(
                                            TabCompleteElement.generateBlanks(Util.getAllQuestionTypeNames(), true, false)
                                    )))
                            ))),
                            new TabCompleteElement("take", true, false, new TabCompleteElementCollection(List.of(
                                    TabCompleteElement.generateBlanks(Util.getAllOnlineUsernames(), true, false)
                            )))
                    )))
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

        return elms.getTriggers(sender, args[args.length-1], sender.isOp());
    }
}
