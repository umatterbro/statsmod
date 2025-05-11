package xyz.squables.statsmod;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

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
        switch(n) {
            case 0: return ChatColor.translateAlternateColorCodes('&', "&c");
            case 1: return ChatColor.translateAlternateColorCodes('&', "&6");
            case 2: return ChatColor.translateAlternateColorCodes('&', "&e");
            case 3: return ChatColor.translateAlternateColorCodes('&', "&a");
            case 4: return ChatColor.translateAlternateColorCodes('&', "&9");
            default: return ChatColor.translateAlternateColorCodes('&', "&r");
        }
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
