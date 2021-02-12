package br.com.quantum.eventsplus.utils;

import org.bukkit.ChatColor;

public class Utilities {
    public static String formatText(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String clearText(String text) {
        return ChatColor.stripColor(text);
    }
}
