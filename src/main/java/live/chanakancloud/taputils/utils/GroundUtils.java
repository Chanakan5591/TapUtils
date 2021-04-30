package live.chanakancloud.taputils.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class GroundUtils {
    /** get the distance in block from ground to player
     *
     * @param e the player to be check
     * @return int
     */
    public static int getDistanceFromGround(Player e){
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--){
            loc.setY(i);
            if(loc.getBlock().getType().isSolid())break;
            distance++;
        }

        return distance;
    }

    /** check if the location is near ground
     *
     * @param location the location to be check
     * @return boolean
     */
    public static boolean isNearGround(Location location) {
        double expand = 0.3;
        for (double x = -expand; x <= expand; x += expand) {
            for (double z = -expand; z <= expand; z += expand) {
                if (location.clone().add(x, -0.5001, z).getBlock().getType() != Material.AIR) {
                    return true;
                }
            }
        }
        return false;
    }

}
