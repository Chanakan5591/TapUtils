package live.chanakancloud.taputils.utils;

import live.chanakancloud.taputils.TapUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerUtils {
    /** check if the player is near the water
     *
     * @param player the player to be check
     * @return boolean
     */
    public static boolean isNearWater(Player player) {
        return player.getLocation().getBlock().isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.UP).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.DOWN).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.NORTH).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.SOUTH).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.EAST).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.WEST).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.NORTH_EAST).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.NORTH_WEST).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.SOUTH_EAST).isLiquid()
                || player.getLocation().getBlock().getRelative(BlockFace.SOUTH_WEST).isLiquid();
    }

    /** check if the location of something is ascending
     *
     * @param from Location from
     * @param to Location to
     * @return boolean
     */
  
    public static boolean isAscending(Location from, Location to) {
        return to.getY() > from.getY();
    }

    /** check if the location of something is descending
     *
     * @param from Location from
     * @param to Location to
     * @return boolean
     */

    public static boolean isDescending(Location from, Location to) {
        return !isAscending(from, to);
    }

    /** get player from their uuid
     *
     * @param uuid UUID of the player to get
     * @return Player
     */

    public static Player getPlayer(UUID uuid) {
        return TapUtils.getPlugin().getServer().getPlayer(uuid);
    }

    /** check if the player is online
     *
     * @param uuid the uuid of the player
     * @return boolean
     */

    public static boolean isPlayerOnline(UUID uuid) {
        for (Player onlinePlayer : TapUtils.getPlugin().getServer().getOnlinePlayers()) {
            if(onlinePlayer.getUniqueId().equals(uuid)) return true;
        }
        return false;
    }

    /** get player by their name
     *
     * @param name the string of player name
     * @return Player
     */

    public static Player getPlayerByName(String name) {
        return TapUtils.getPlugin().getServer().getPlayerExact(name);
    }
}
