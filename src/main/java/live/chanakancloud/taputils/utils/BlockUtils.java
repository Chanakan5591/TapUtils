package live.chanakancloud.taputils.utils;

import org.bukkit.Material;

public class BlockUtils {
    public static float getFriction(Material material) {
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
}
