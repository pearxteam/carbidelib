package ru.pearx.lib.math;

/*
 * Created by mrAppleXZ on 03.07.17 22:36.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * PearXLib Utils related to mathematics.
 */
public class MathUtils
{
    /**
     * Gets an arithmetical average of integers.
     * @param ints Input
     * @return Output
     */
    public static int getAverage(int... ints)
    {
        int result = 0;
        for(int i : ints)
            result += i;
        return result / ints.length;
    }

    /**
     * Gets an arithmetical average of doubles.
     * @param doubles Input
     * @return Output
     */
    public static double getAverageDouble(double... doubles)
    {
        double result = 0;
        for(double d : doubles)
            result += d;
        return result / doubles.length;
    }

    /**
     * Checks if "i" is even.
     * @param i Integer to check.
     * @return True if "i" is even, otherwise false.
     */
    public static boolean isEven(int i)
    {
        return i % 2 == 0;
    }

    /**
     * Gets the nearest to "val" value in power of "powerOf". For example, if "val" is 121 and "powerOf" is 2, the method must return 128.
     * @param val Input
     * @param powerOf Power of.
     * @return Nearest to "val" value in power of "powerOf"
     */
    public static int getNearestPowerOf(int val, int powerOf)
    {
        int vp2 = 0;
        for (int i = 1; vp2 < val; i++)
            vp2 = (int) Math.pow(powerOf, i);
        return vp2;
    }

    /**
     * Gets a greatest common divider of "a" and "b" using Euclid's algorithm.
     * @param a Input #1.
     * @param b Input #2.
     * @return Output.
     */
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

    /**
     * Rounds a double to nth digits after point.
     * @param d Double.
     * @param n Digits after point.
     * @return Rounded double.
     */
    public static double roundDouble(double d, int n)
    {
        return new BigDecimal(d).setScale(n, RoundingMode.HALF_UP).doubleValue();
    }

    public static float toRadians(float degrees)
    {
        return degrees / 180 * 3.141592653589793f;
    }


    //todo integer support.
    /**
     * Calculates a X position. May be useful for configs.
     * @param width Width of an element.
     * @param mainWidth Width of an element's parent.
     * @param xPos X position in the string presentation. Allowed values: "left", "center", "right".
     */
    public static int calculateXPosition(int width, int mainWidth, String xPos)
    {
        if(!xPos.equals("left") && !xPos.equals("center") && !xPos.equals("right"))
            throw new IllegalArgumentException("xPos may be only 'left', 'center' and 'right'.");

        switch (xPos)
        {
            case "left":
                return 0;
            case "center":
                return (mainWidth - width) / 2;
            case "right":
                return mainWidth - width;
        }
        return -1;
    }

    //todo integer support.
    /**
     * Calculates an Y position. May be useful for configs.
     * @param height Height of an element.
     * @param mainHeight Height of an element's parent.
     * @param yPos Y position in the string presentation. Allowed values: "top", "middle", "bottom".
     */
    public static int calculateYPosition(int height, int mainHeight, String yPos)
    {
        if(!yPos.equals("top") && !yPos.equals("middle") && !yPos.equals("bottom"))
            throw new IllegalArgumentException("yPos may be only 'top', 'middle' and 'bottom'.");

        switch (yPos)
        {
            case "top":
                return 0;
            case "middle":
                return (mainHeight - height) / 2;
            case "bottom":
                return mainHeight - height;
        }
        return -1;
    }

    /**
     * Gets the nearest to 'val' value in 'array'.
     * @param array An input array.
     * @param val An input value.
     * @return Index of the nearest element.
     */
    public static int getNearest(int[] array, int val)
    {
        int index = 0;
        int value = Math.abs(array[0] - val);
        for(int i = 0; i < array.length; i++)
        {
            int abs = Math.abs(array[i] - val);
            if (abs < value)
            {
                value = abs;
                index = i;
            }
        }
        return index;
    }
}
