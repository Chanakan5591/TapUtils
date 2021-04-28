package live.chanakancloud.taputils.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {
    public static float getFriction(XMaterial material) {
        switch(material) {
            case SLIME_BLOCK:
                return 0.8f;
            case ICE:
            case PACKED_ICE:
            case FROSTED_ICE:
                return 0.98f;
            case BLUE_ICE:
                return 0.989f;
            default:
                return 0.6f;
        }
    }

    public static Block getTopBlock(Player player) {
        Location loc = player.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i++){
            loc.setY(i);
            if(loc.getBlock().getType().isSolid()) return loc.getBlock();
            if(loc.getY() >= 256) break;
        }
        return null;
    }

    public static Block getTopBlock(Block block) {
        Location loc = block.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i++) {
            loc.setY(i);
            if (loc.getBlock().getType().isSolid()) return loc.getBlock();
            if(loc.getY() >= 256) break;
        }
        return null;
    }

    public List<Block> getBlockInRadius(Player player, int radius) {
        List<Block> blocks = new ArrayList<>();
        Block block = player.getLocation().getBlock();

        for (int x = -(radius); x <= radius; x ++) {
            for (int y = -(radius); y <= radius; y++) {
                for (int z = -(radius); z <= radius; z++) {
                    blocks.add(block.getRelative(x, y, z));
                }
            }
        }
        return blocks;
    }

    public List<Block> getBlockInRadius(Block block, int radius) {
        List<Block> blocks = new ArrayList<>();

        for (int x = -(radius); x <= radius; x++) {
            for (int y = -(radius); y <= radius; y++) {
                for (int z = -(radius); z <= radius; z++) {
                    blocks.add(block.getRelative(x,y,z));
                }
            }
        }
        return blocks;
    }

    public static Block getBlockFromGround(Player player) {
        Location loc = player.getLocation().clone();
        double y = loc.getBlockY();
        for (double i = y; i >= 0; i--){
            loc.setY(i);
            if(loc.getBlock().getType().isSolid()) {
                return loc.getBlock();
            }
        }
        return null;
    }
    
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
