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

    public static boolean contains(Object[] array, Object obj) {
        for (Object object : array) if (object != null && object.equals(obj)) return true;
        return false;
    }

    public static ItemStack createItemStack(Material material, int amount, String name, String... lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(colorize(name));
        List<String> loreList = new ArrayList<>();
        for (String loree : lore) {
            loreList.add(colorize(loree));
        }
        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
