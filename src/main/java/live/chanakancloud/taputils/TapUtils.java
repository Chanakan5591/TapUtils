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
    /** The Plugin instance should be set here */
    @Getter @Setter private static JavaPlugin plugin;
    /** To set ChatColor */
    @Getter @Setter private static ChatColor prefixColor;
    /** Plugin Name, Will be use as prefix also */
    @Getter @Setter private static String pluginName;

}
