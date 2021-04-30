package live.chanakancloud.taputils.math;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class MathUtils {

    private static final int SIN_BITS, SIN_MASK, SIN_COUNT;
    private static final float radFull, radToIndex;
    private static final float degFull, degToIndex;
    private static final float[] sin, cos;

    static {
        SIN_BITS = 12;
        SIN_MASK = ~(-1 << SIN_BITS);
        SIN_COUNT = SIN_MASK + 1;

        radFull = (float) (Math.PI * 2.0);
        degFull = (float) (360.0);
        radToIndex = SIN_COUNT / radFull;
        degToIndex = SIN_COUNT / degFull;

        sin = new float[SIN_COUNT];
        cos = new float[SIN_COUNT];

        for (int i = 0; i < SIN_COUNT; i++) {
            sin[i] = (float) Math.sin((i + 0.5f) / SIN_COUNT * radFull);
            cos[i] = (float) Math.cos((i + 0.5f) / SIN_COUNT * radFull);
        }

        // Four cardinal directions (credits: Nate)
        for (int i = 0; i < 360; i += 90) {
            sin[(int) (i * degToIndex) & SIN_MASK] = (float) Math.sin(i * Math.PI / 180.0);
            cos[(int) (i * degToIndex) & SIN_MASK] = (float) Math.cos(i * Math.PI / 180.0);
        }
    }


    /** Calculate chanceOf with percent as input
     * @param percent the number as percentage
     * @return boolean
     */
    public static boolean chanceOfPercent(Number percent) {
        if(percent.doubleValue() <= 0.0) {
            return false;
        }
        return chanceOfDec(percent.doubleValue()/100.0);
    }

    /** Calculate chanceOf with normal decimal as input
     * @param decimal the number as normal decimal
     * @return boolean
     */
    public static boolean chanceOfDec(Number decimal) {
        if(decimal.doubleValue() <= 0.0) {
            return false;
        }
        return Math.random() < decimal.doubleValue();
    }

    /** Round a number of double with decimal places.
     *
     * @param value the value to be round
     * @param places decimal places to round
     * @return Double
     */
    public static Double round(double value, int places) {
        if (places < 0) return null;
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        return bd.doubleValue();
    }

    /** A more efficient sin function
     *
     * @param rad radius to calculate in float
     * @return float
     */

    public static float sin(float rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }


    /** A more efficient sin function
     *
     * @param rad radius to calculate in double
     * @return double
     */

    public static double sin(double rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }


    /** A more efficient cos function
     *
     * @param rad radius to calculate in float
     * @return float
     */

    public static float cos(float rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }


    /** A more efficient cos function
     *
     * @param rad radius to calculate in double
     * @return double
     */

    public static double cos(double rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }

    /** To calculate DeltaY
     *
     * @param fromY Y Location from
     * @param toY Y Location to
     * @return double
     */

    public static double calculateDeltaY(double fromY, double toY) {
        return toY - fromY;
    }

    /** to calculate 3D distance
     *
     * @param one First Vector
     * @param two Second Vector
     * @return double
     */

    public static double get3DDistance(Vector one, Vector two) {
        return hypot(one.getX() - two.getX(), one.getY() - two.getY(), one.getZ() - two.getZ());
    }


    /** A square root function for float using more efficient sqrt function
     *
     * @param value the float value to square root
     * @return float
     */
    public static float sqrt_float(float value) {
        return (float) sqrt((double) value);
    }

    /** A square root function for double using more efficient sqrt function
     *
     * @param value the double value to square root
     * @return float
     */
    public static float sqrt_double(double value) {
        return (float) sqrt(value);
    }

    /** A floor function for float
     *
     * @param value float value to floor
     * @return int
     */
    public static int floor_float(float value) {
        int i = (int) value;
        return value < (float) i ? i - 1 : i;
    }

    /** calculate absolute value of float
     *
     * @param value float value to calculate
     * @return float
     */
    public static float abs(float value) {
        return value >= 0.0F ? value : -value;
    }
  
    /** calculate absolute value of int
     *
     * @param value int value to calculate
     * @return int
     */

    public static int abs_int(int value) {
        return value >= 0 ? value : -value;
    }


    /** an average function
     *
     * @param values long[] value to average
     * @return double
     */

    public static double average(long[] values) {
        long i = 0L;

        for (long j : values) {
            i += j;
        }

        return (double) i / (double) values.length;
    }

    /** check if player have moved
     *
     * @param from Vector from
     * @param to Vector to
     * @return boolean
     */
    public static boolean playerMoved(Vector from, Vector to) {
        return from.distance(to) > 0;
    }


    /** Check if player have looked
     *
     * @param from Vector from
     * @param to Vector to
     * @return boolean
     */
    public static boolean playerLooked(Location from, Location to) {
        return (from.getYaw() - to.getYaw() != 0) || (from.getPitch() - to.getPitch() != 0);
    }

    /** hypotenuse double value in double
     *
     * @param value double... value to hypot
     * @return double
     */
  
    public static double hypot(double... value) {
        double total = 0;

        for (double val : value) {
            total += (val * val);
        }

        return Math.sqrt(total);
    }

    /** hypotenuse double value in float
     *
     * @param value double... value to hypot
     * @return float
     */

    public static float hypot(float... value) {
        float total = 0;

        for (float val : value) {
            total += (val * val);
        }

        return (float) Math.sqrt(total);
    }


    /** calculate greatest common divisor using euclidean
     *
     * @param input long... value to gcd
     * @return long
     */

    public static long gcd(long... input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    /** a more efficient but slightly less accurate sqrt function in double
     *
     * @param num double value to sqrt
     * @return double
     */

    public static double sqrt(double num) {
        if(num == 0) return 0;
        double t;
        double squareRoot = num / 2;

        do {
            t = squareRoot;
            squareRoot = (t + (num / t)) / 2;
        } while ((t - squareRoot) != 0);

        return squareRoot;
    }


    /** get direction from yaw and pitch
     *
     * @param yaw double value of yaw
     * @param pitch double value of pitch
     * @return Vector
     */

    public static Vector getDirection(double yaw, double pitch) {
        Vector vector = new Vector();
        vector.setY(-sin(Math.toRadians(pitch)));
        double xz = cos(Math.toRadians(pitch));
        vector.setX(-xz * sin(Math.toRadians(yaw)));
        vector.setZ(xz * cos(Math.toRadians(yaw)));
        return vector;
    }

    /** a more efficient but slightly less accurate sqrt function in float
     *
     * @param number float value to calculate sqrt
     * @return float
     */

    public static float sqrt(float number) {
        if(number == 0) return 0;
        float t;

        float squareRoot = number / 2;

        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);

        return squareRoot;
    }
  
    /** least common multiple computation in long
     *
     * @param a long first value
     * @param b long second value
     * @return long
     */

    public static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    /** calculate mode of int
     *
     * @param array int []array value to calculate mode
     * @return int
     */

    public static int mode(int []array)
    {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int max  = 1;
        int temp = 0;

        for (int j : array) {

            if (hashMap.get(j) != null) {

                int count = hashMap.get(j);
                count++;
                hashMap.put(j, count);

                if (count > max) {
                    max = count;
                    temp = j;
                }
            } else
                hashMap.put(j, 1);
        }
        return temp;
    }

    /** get horizontal distance
     *
     * @param from location from
     * @param to location to
     * @return double
     */
    public static double getHorizontalDistance(Location from, Location to) {
        double deltaX = to.getX() - from.getX(), deltaZ = to.getZ() - from.getZ();
        return sqrt(deltaX * deltaX + deltaZ * deltaZ);
    }


    /** lcm calculation with long...
     *
     * @param input long... value to calculate
     * @return long
     */

    public static long lcm(long... input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }
}
