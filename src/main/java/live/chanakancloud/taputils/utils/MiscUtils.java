package live.chanakancloud.taputils.utils;

import live.chanakancloud.taputils.TapUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MiscUtils {

    private static void toConsole(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    /** to send message to console (can be colorize with & follow by color code)
     *
     * @param message the message to be send
     */
    public static void sendToConsole(String message) {
        toConsole(Bukkit.getConsoleSender(), TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message);
    }

    /** log message to console
     *
     * @param message the message to be log (will implement log level in future releases)
     */

    public static void log(String message) {
        sendToConsole(message);
    }

    /** send message to player
     *
     * @param player the player for message to be send
     * @param message the message to be send to the player
     */

    public static void sendToPlayer(Player player, String message) {
        player.sendMessage(colorize(TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message));
    }

    private static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /** send message to the command sender
     *
     * @param commandSender the command sender for message to be send to
     * @param message the message to be send
     */
    public static void sendToCommandSender(CommandSender commandSender, String message) {
        commandSender.sendMessage(colorize(TapUtils.getPrefixColor() + "[" + TapUtils.getPluginName() + "] " + ChatColor.WHITE + message));
    }

    /** check if the object array contain an object
     *
     * @param array the Object[] array to be check
     * @param obj an object to be search for
     * @return boolean
     */
    public static boolean contains(Object[] array, Object obj) {
        for (Object object : array) if (object != null && object.equals(obj)) return true;
        return false;
    }

    /** combine 2 list together
     *
     * @param first first list to be combine
     * @param second second list to be combine
     * @return List<T>
     */
    public static <T> List<T> combine(List<T> first, List<T> second) {
        first.addAll(second);

        return first;
    }

}
