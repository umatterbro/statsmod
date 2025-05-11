package xyz.squables.statsmod;

import org.bukkit.ChatColor;

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
        switch(n) {
            case 0: return ChatColor.translateAlternateColorCodes('&', "&c");
            case 1: return ChatColor.translateAlternateColorCodes('&', "&6");
            case 2: return ChatColor.translateAlternateColorCodes('&', "&e");
            case 3: return ChatColor.translateAlternateColorCodes('&', "&a");
            case 4: return ChatColor.translateAlternateColorCodes('&', "&9");
            default: return ChatColor.translateAlternateColorCodes('&', "&r");
        }
    }
}
