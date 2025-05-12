package xyz.squables.statsmod;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.question.types.QuestionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static int generateRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public static double generateRandomDouble(double min, double max) {
        Random r = new Random();
        return r.nextDouble(max - min) + min;
    }

    public static double roundToN(double number, int n) {
        double scale = Math.pow(10, n);
        return Math.round(number * scale) / scale;
    }

    public static String intToColor(int n) {
        return switch (n) {
            case 0 -> ChatColor.translateAlternateColorCodes('&', "&c");
            case 1 -> ChatColor.translateAlternateColorCodes('&', "&6");
            case 2 -> ChatColor.translateAlternateColorCodes('&', "&e");
            case 3 -> ChatColor.translateAlternateColorCodes('&', "&a");
            case 4 -> ChatColor.translateAlternateColorCodes('&', "&9");
            default -> ChatColor.translateAlternateColorCodes('&', "&r");
        };
    }

    public static List<String> getAllOnlineUsernames() {
        List<String> usns = new ArrayList<>();
        for(Player p : Bukkit.getOnlinePlayers()) {
            usns.add(p.getName());
        }

        return usns;
    }

    public static List<String> getAllQuestionTypeNames() {
        List<String> names = new ArrayList<>();
        for(var q : QuestionType.values()) names.add(q.name().toLowerCase());
        return names;
    }

    public static String joinAndAddAnd(List<String> strs) {
        List<String> newStrs = new ArrayList<>();
        for(int i = 0; i < strs.size()-1; i++) {
            newStrs.add(strs.get(i));
        }

        return String.join(", ", newStrs) + " and " + strs.getLast();
    }

    /*public static List<Location> availableSpawnLocationsWithinRadius(Player p, int radius) {
        Location pl = p.getLocation();
        World pw = p.getWorld();
        int bx = pl.getBlockX();
        int by = pl.getBlockY();
        int bz = pl.getBlockZ();

        List<Location> locs = new ArrayList<>();
        for(int x = bx - radius; x <= bx + radius; x++) {
            for(int y = by - radius; y <= by + radius; y++) {
                for(int z = bz - radius; z <= bz + radius; z++) {
                    Block b1 = pw.getBlockAt(x, y, z);
                    Block b2 = pw.getBlockAt(x, y+1, z);

                    if(b1.getType() != Material.AIR || b1.getType() != Material.CAVE_AIR || b2.getType() != Material.AIR || b2.getType() != Material.AIR) {
                        p.sendMessage("skipped (" + bx + ", " + by + ", " + bz + ") " + b1.getType() + ", " + b2.getType());
                        continue;
                    }

                    locs.add(b1.getLocation());
                }
            }
        }

        return locs;
    }*/
}
