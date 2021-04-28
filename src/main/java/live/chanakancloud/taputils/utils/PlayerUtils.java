package live.chanakancloud.taputils.utils;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

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



}
