package live.chanakancloud.taputils.utils;

import live.chanakancloud.taputils.TapUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerUtils {
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

    public static boolean isAscending(Location from, Location to) {
        return to.getY() > from.getY();
    }

    public static boolean isDescending(Location from, Location to) {
        return !isAscending(from, to);
    }

    public static Player getPlayer(UUID uuid) {
        return TapUtils.getPlugin().getServer().getPlayer(uuid);
    }

    public static boolean isPlayerOnline(UUID uuid) {
        for (Player onlinePlayer : TapUtils.getPlugin().getServer().getOnlinePlayers()) {
            if(onlinePlayer.getUniqueId().equals(uuid)) return true;
        }
        return false;
    }

    public static Player getPlayerByName(String name) {
        return TapUtils.getPlugin().getServer().getPlayerExact(name);
    }
}
