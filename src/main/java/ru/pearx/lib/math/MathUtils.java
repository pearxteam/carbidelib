package ru.pearx.lib.math;

/*
 * Created by mrAppleXZ on 03.07.17 22:36.
 */
public class MathUtils
{
    public static int getAverage(int... ints)
    {
        int result = 0;
        for(int i : ints)
            result += i;
        return result / ints.length;
    }

    public static double getAverageDouble(double... doubles)
    {
        double result = 0;
        for(double d : doubles)
            result += d;
        return result / doubles.length;
    }

    public static boolean isEven(int i)
    {
        return i % 2 == 0;
    }

    public static int getNearestPowerOf(int val, int powerOf)
    {
        int vp2 = 0;
        for (int i = 1; vp2 < val; i++)
            vp2 = (int) Math.pow(powerOf, i);
        return vp2;
    }

    public static long getGcdEuclid(long a, long b)
    {
        long bigger = Math.max(a, b);
        long lower = Math.min(a, b);
        if (bigger == 0 || lower == 0)
            return 0;
        while (lower != 0)
        {
            long tmp = bigger % lower;
            bigger = lower;
            lower = tmp;
        }
        return bigger;
    }
}
