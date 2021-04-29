package live.chanakancloud.taputils;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TapUtils {
    @Getter @Setter private static JavaPlugin plugin;
    @Getter @Setter private static ChatColor prefixColor;
    @Getter @Setter private static String pluginName;
    @Getter @Setter private static String pastebin_api_user_key;

}
