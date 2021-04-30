package live.chanakancloud.taputils;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/** Main Class To initialize the library
 * @author Chanakan Mungtin
 * @version 1.1.2
 * @since 1.0.0
 */
public class TapUtils {
    @Getter @Setter private static JavaPlugin plugin;
    @Getter @Setter private static ChatColor prefixColor;
    @Getter @Setter private static String pluginName;

}
