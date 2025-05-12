package xyz.squables.statsmod.cmd.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.squables.statsmod.PlayerQuestions;
import xyz.squables.statsmod.Statsmod;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.question.types.QuestionType;
import xyz.squables.statsmod.result.PlayerResult;

public class StatsCommand implements CommandExecutor {
    private final PlayerQuestions pq = Statsmod.getPq();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter an argument"));
            return true;
        }

        String cmd = args[0];
        if(cmd.equals("debug")) {
            if(args.length == 1) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter debug argument"));
                return true;
            }

            String subcmd = args[1];
            if(subcmd.equals("question")) {
                if(args.length == 2) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter question argument"));
                    return true;
                }

                String qcmd = args[2];
                if(qcmd.equals("give")) {
                    if(args.length >= 4) {
                        String pn = args[3];
                        Player p = Bukkit.getPlayer(pn);
                        if(p == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't online"));
                            return true;
                        }

                        if(pq.isPlayerOccupied(sender.getName())) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " is already doing a question"));
                            return true;
                        }

                        if(args.length == 5) {
                            String qtype = args[4];
                            if(!Util.getAllQuestionTypeNames().contains(qtype)) {
                                p.sendMessage("&cEnter a valid question type");
                                return true;
                            }

                            QuestionType qt = QuestionType.valueOf(qtype.toUpperCase());
                            Question q = Question.generateQuestion(qt);
                            pq.setQuestionAnswer(p.getName(), q);

                            q.send(p, true);
                            sender.sendMessage("Gave " + q.type.name() + " type question to " + pn);
                        } else {
                            Question q = Question.generateQuestion();
                            pq.setQuestionAnswer(p.getName(), q);

                            q.send(p, true);
                            sender.sendMessage("Gave " + q.type.name() + " type question to " + pn);
                        }
                    } else {
                        if(!(sender instanceof Player)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need to be a player to do that"));
                            return true;
                        }

                        Player p = ((Player) sender);
                        String pn = p.getName();
                        if(pq.isPlayerOccupied(pn)) {
                            p.sendMessage("First finish the question you're currently on");
                            return true;
                        }

                        Question q = Question.generateQuestion();
                        pq.setQuestionAnswer(pn, q);

                        q.send(p, true);
                        sender.sendMessage("Gave " + q.type.name() + " type question to " + pn);
                    }
                } else if(qcmd.equals("get")) {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need to be a player to do that"));
                        return true;
                    }

                    if(args.length == 4) {
                        String pn = args[3];
                        Player p = Bukkit.getPlayer(pn);
                        if(p == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't online"));
                            return true;
                        }

                        if(!pq.isPlayerOccupied(pn)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't doing a question"));
                            return true;
                        }

                        var q = pq.getQuestion(pn);
                        q.send(((Player) sender), false);
                    } else {
                        Player p = ((Player) sender);
                        String pn = p.getName();
                        if(!pq.isPlayerOccupied(pn)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou aren't doing a question"));
                            return true;
                        }

                        var q = pq.getQuestion(pn);
                        q.send(p, false);
                    }
                } else if(qcmd.equals("take")) {
                    if(args.length == 4) {
                        String pn = args[3];
                        Player p = Bukkit.getPlayer(pn);
                        if(p == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't online"));
                            return true;
                        }

                        if(!pq.isPlayerOccupied(pn)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't doing a question"));
                            return true;
                        }

                        pq.clearMap(pn);
                        sender.sendMessage("Took question from " + pn);
                        p.sendMessage("you've been released...");
                    } else {
                        if(!(sender instanceof Player)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need to be a player to do that"));
                            return true;
                        }

                        Player p = ((Player) sender);
                        String pn = p.getName();
                        if(!pq.isPlayerOccupied(pn)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou aren't doing a question"));
                            return true;
                        }

                        pq.clearMap(pn);
                        p.sendMessage("you've been released...");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter valid question argument"));
                    return true;
                }
            } else if(subcmd.equals("result")) {
                if(args.length == 2) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter result argument"));
                    return true;
                }

                String rcmd = args[2];
                PlayerResult pr = null;
                for(PlayerResult pres : PlayerResult.getAll()) {
                    if(pres.getClass().getSimpleName().equals(rcmd)) {
                        pr = pres;
                        break;
                    }
                }

                if(pr == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnknown error finding " + rcmd));
                    return true;
                }

                if(args.length == 4) {
                    String pn = args[3];
                    Player p = Bukkit.getPlayer(pn);

                    if(p == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer " + pn + " isn't online"));
                        return true;
                    }

                    sender.sendMessage("Using " + rcmd + " on " + p.getName());
                    pr.executeOn(p);
                } else {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need to be a player to do that"));
                        return true;
                    }

                    Player p = ((Player) sender);
                    p.sendMessage("Using " + rcmd + " on " + p.getName());
                    pr.executeOn(p);
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter valid debug argument"));
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter a valid argument"));
            return true;
        }

        return true;
    }
}
