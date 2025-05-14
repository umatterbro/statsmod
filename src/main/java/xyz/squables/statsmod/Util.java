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

    public static <T> List<T> generateAmountNoDupes(T[] original, int amount) {
        if(original.length - 1 >= amount) throw new IllegalArgumentException("amount cannot be greater than the size of the given array");

        List<T> ret = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            while(true) {
                T obj = original[Util.generateRandomInt(0, original.length)];
                if(ret.contains(obj)) continue;
                ret.add(obj);
                break;
            }
        }

        return ret;
    }

    public static <T> List<T> generateAmountNoDupes(List<T> original, int amount) {
        if(original.size() - 1 >= amount) throw new IllegalArgumentException("amount cannot be greater than the size of the given array");

        List<T> ret = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            while(true) {
                T obj = original.get(Util.generateRandomInt(0, original.size()));
                if(ret.contains(obj)) continue;
                ret.add(obj);
                break;
            }
        }

        return ret;
    }

    public static List<Integer> generateRandomDigits(int amount) {
        List<Integer> ints = new ArrayList<>();
        for(int i = 0; i < amount; i++) ints.add(Util.generateRandomInt(10001, 99999));
        return ints;
    }

    public static List<Integer> stringListToIntList(List<String> strs) {
        List<Integer> nums = new ArrayList<>();
        for(String s : strs) nums.add(Integer.valueOf(s));
        return nums;
    }

    public static <T extends Number> List<String> numberGenericListToStringList(List<T> nums) {
        List<String> strs = new ArrayList<>();
        for(T i : nums) strs.add(String.valueOf(i));
        return strs;
    }

    public static List<String> splitInto(String str, int pieceSize, boolean appendExtra) {
        int strLen = str.length();
        //if (strLen % pieceSize != 0) throw new IllegalArgumentException("length of str must be divisible by pieceSize (" + strLen + " % " + pieceSize + " = " + strLen % pieceSize + ")");

        List<String> splits = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            current.append(str.charAt(i));
            if ((i+1) % pieceSize == 0 && i != 0) {
                splits.add(current.toString());
                current = new StringBuilder();
            }
        }

        if(!current.isEmpty() && appendExtra) splits.add(current.toString());

        return splits;
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
