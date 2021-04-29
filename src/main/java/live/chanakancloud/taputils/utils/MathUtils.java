package live.chanakancloud.taputils.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

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

    public static float sin(float rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static double sin(double rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static float cos(float rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static double cos(double rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static double calculateDeltaY(double fromY, double toY) {
        return toY - fromY;
    }

    public static double get3DDistance(Vector one, Vector two) {
        return hypot(one.getX() - two.getX(), one.getY() - two.getY(), one.getZ() - two.getZ());
    }

    public static float sqrt_float(float value) {
        return (float) Math.sqrt((double) value);
    }

    public static float sqrt_double(double value) {
        return (float) Math.sqrt(value);
    }

    public static int floor_float(float value) {
        int i = (int) value;
        return value < (float) i ? i - 1 : i;
    }

    public static float abs(float value) {
        return value >= 0.0F ? value : -value;
    }

    public static int abs_int(int value) {
        return value >= 0 ? value : -value;
    }

    public static double average(long[] values) {
        long i = 0L;

        for (long j : values) {
            i += j;
        }

        return (double) i / (double) values.length;
    }

    public static boolean playerMoved(Vector from, Vector to) {
        return from.distance(to) > 0;
    }

    public static boolean playerLooked(Location from, Location to) {
        return (from.getYaw() - to.getYaw() != 0) || (from.getPitch() - to.getPitch() != 0);
    }

    public static double hypot(double... value) {
        double total = 0;

        for (double val : value) {
            total += (val * val);
        }

        return Math.sqrt(total);
    }

    public static float hypot(float... value) {
        float total = 0;

        for (float val : value) {
            total += (val * val);
        }

        return (float) Math.sqrt(total);
    }

    public static long gcd(long... input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

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

    public static Vector getDirection(double yaw, double pitch) {
        Vector vector = new Vector();
        vector.setY(-sin(Math.toRadians(pitch)));
        double xz = cos(Math.toRadians(pitch));
        vector.setX(-xz * sin(Math.toRadians(yaw)));
        vector.setZ(xz * cos(Math.toRadians(yaw)));
        return vector;
    }

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

    public static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    public static int mode(int []array)
    {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int max  = 1;
        int temp = 0;

        for(int i = 0; i < array.length; i++) {

            if (hashMap.get(array[i]) != null) {

                int count = hashMap.get(array[i]);
                count++;
                hashMap.put(array[i], count);

                if(count > max) {
                    max  = count;
                    temp = array[i];
                }
            }

            else
                hashMap.put(array[i],1);
        }
        return temp;
    }


    public static double getHorizontalDistance(Location from, Location to) {
        double deltaX = to.getX() - from.getX(), deltaZ = to.getZ() - from.getZ();
        return sqrt(deltaX * deltaX + deltaZ * deltaZ);
    }

    public static long lcm(long... input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }
}
