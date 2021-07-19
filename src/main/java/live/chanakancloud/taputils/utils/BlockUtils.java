package live.chanakancloud.taputils.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {
    /**
     * to get friction of all ice blocks
     *
     * @param material the Material to be check
     * @return float
     */
    public static float getFriction(XMaterial material) {
        return switch (material) {
            case SLIME_BLOCK -> 0.8f;
            case ICE, PACKED_ICE, FROSTED_ICE -> 0.98f;
            case BLUE_ICE -> 0.989f;
            default -> 0.6f;
        };
    }

    /**
     * get the blocks at the top of player
     *
     * @param player the player to be check
     * @return Block, null if not exist after 256 blocks checking
     */
    public static Block getTopBlock(Player player) {
        Location loc = player.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i++) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) return loc.getBlock();
            if (loc.getY() >= 256) break;
        }
        return null;
    }

    /**
     * get the blocks at the top of another block
     *
     * @param block the block to be check
     * @return Block, null if not exist after 256 blocks checking
     */
    public static Block getTopBlock(Block block) {
        Location loc = block.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i++) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) return loc.getBlock();
            if (loc.getY() >= 256) break;
        }
        return null;
    }

    /**
     * get block around player within radius
     *
     * @param player the player to be check
     * @param radius radius of blocks be scan.
     * @return List<Block>
     */
    public static List<Block> getBlockInRadius(Player player, int radius, boolean withAir) {
        List<Block> blocks = new ArrayList<>();
        Block block = player.getLocation().getBlock();

        for (int x = -(radius); x <= radius; x++) {
            for (int y = -(radius); y <= radius; y++) {
                for (int z = -(radius); z <= radius; z++) {
                    if (!withAir && block.getRelative(x, y, z).getType() != Material.AIR) {
                        blocks.add(block.getRelative(x, y, z));
                    } else if(withAir) {
                        blocks.add(block.getRelative(x, y, z));
                    }
                }
            }
        }
        return blocks;
    }

    /**
     * get block around block within radius
     *
     * @param block  the block to be check
     * @param radius radius of blocks be scan.
     * @param withAir if to include AIR block into the search.
     * @return List<Block>
     */
    public static List<Block> getBlockInRadius(Block block, int radius, boolean withAir) {
        List<Block> blocks = new ArrayList<>();

        for (int x = -(radius); x <= radius; x++) {
            for (int y = -(radius); y <= radius; y++) {
                for (int z = -(radius); z <= radius; z++) {
                    if(!withAir && block.getRelative(x, y ,z).getType() != Material.AIR)
                        blocks.add(block.getRelative(x, y, z));
                    else if(withAir)
                        blocks.add(block.getRelative(x, y, z));
                }
            }
        }
        return blocks;
    }

    /**
     * get the block at the ground of player
     *
     * @param player the player to be check
     * @return Block, null if none
     */
    public static Block getBlockFromGround(Player player) {
        Location loc = player.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i--) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) {
                return loc.getBlock();
            }
        }
        return null;
    }

    /**
     * get the block at the ground of another block
     *
     * @param block the block to be check
     * @return Block, null if none
     */
    public static Block getBlockFromGround(Block block) {
        Location loc = block.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i--) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) {
                return loc.getBlock();
            }
        }
        return null;
    }
}
