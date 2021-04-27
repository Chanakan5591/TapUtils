package live.chanakancloud.taputils.utils;

import live.chanakancloud.taputils.TapUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiscUtils {
    private static void toConsole(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static void sendToConsole(String message) {
        toConsole(Bukkit.getConsoleSender(), TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message);
    }

    public static void sendToPlayer(Player player, String message) {
        player.sendMessage(colorize(TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message));
    }

    private static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendToCommandSender(CommandSender commandSender, String message) {
        commandSender.sendMessage(colorize(TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message));
    }

}
