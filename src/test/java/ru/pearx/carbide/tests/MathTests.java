/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.pearx.carbide.math.MathUtils;

/*
 * Created by mrAppleXZ on 04.02.18 10:23.
 */
public class MathTests
{
    public static final float DELTA = 0.00000001f;
    @Test
    public void testAverage()
    {
        assertEquals("Arithmetical average test for positive integers.", 60, MathUtils.getAverage(15, 45, 80, 100));
        assertEquals("Arithmetical average test for negative integers.", -60, MathUtils.getAverage(-15, -45, -80, -100));
        assertEquals("Arithmetical average test for mixed integers.", 10, MathUtils.getAverage(30, -10, -80, 100));
        assertEquals("Arithmetical average test for mixed integers.", 5, MathUtils.getAverage(0, 0, -80, 100));
    }

    @Test
    public void testAverageDoubleInteger()
    {
        assertEquals("Arithmetical average [double] test for positive integers.", 60, MathUtils.getAverageDouble(15, 45, 80, 100), DELTA);
        assertEquals("Arithmetical average [double] test for negative integers.", -60, MathUtils.getAverageDouble(-15, -45, -80, -100), DELTA);
        assertEquals("Arithmetical average [double] test for mixed integers.", 10, MathUtils.getAverageDouble(30, -10, -80, 100), DELTA);
        assertEquals("Arithmetical average [double] test for mixed integers.", 5, MathUtils.getAverageDouble(0, 0, -80, 100), DELTA);
    }

    @Test
    public void testAverageDoubleDouble()
    {
        assertEquals("Arithmetical average [double] test for positive doubles.", 177.61625, MathUtils.getAverageDouble(15.2, 11.3, 128.41, 555.555), DELTA);
        assertEquals("Arithmetical average [double] test for negative doubles.", -177.61625, MathUtils.getAverageDouble(-15.2, -11.3, -128.41, -555.555), DELTA);
        assertEquals("Arithmetical average [double] test for mixed doubles.", 107.76125, MathUtils.getAverageDouble(15.2, -11.3, -128.41, 555.555), DELTA);
        assertEquals("Arithmetical average [double] test for mixed doubles.", 106.78625, MathUtils.getAverageDouble(0, 0, -128.41, 555.555), DELTA);
    }

    @Test
    public void testEven()
    {
        assertTrue("Even test for positive even value.", MathUtils.isEven(108));
        assertFalse("Even test for positive not even value.", MathUtils.isEven(55));
        assertTrue("Even test for negative even value.", MathUtils.isEven(-108));
        assertFalse("Even test for negative not even value.", MathUtils.isEven(-55));
        assertTrue("Even test for zero.", MathUtils.isEven(0));
    }

    @Test
    public void testNearestPowerOf()
    {
        assertEquals("Nearest power of 2 test.", 256, MathUtils.getNearestPowerOf(215, 2));
        assertEquals("Nearest power of 2 test.", 4096, MathUtils.getNearestPowerOf(3400, 2));
        assertEquals("Nearest power of 2 test.", 1048576, MathUtils.getNearestPowerOf(1000000, 2));

        assertEquals("Nearest power of 5 test.", 625, MathUtils.getNearestPowerOf(510, 5));
        assertEquals("Nearest power of 5 test.", 5, MathUtils.getNearestPowerOf(1, 5));
        assertEquals("Nearest power of 5 test.", 0, MathUtils.getNearestPowerOf(0, 5));
    }

    @Test
    public void testGcd()
    {
        assertEquals("GCD test for positive numbers.", 1, MathUtils.getGcdEuclid(2, 5));
        assertEquals("GCD test for positive numbers.", 5, MathUtils.getGcdEuclid(50, 5));
        assertEquals("GCD test for positive numbers.", 1, MathUtils.getGcdEuclid(1, 5));
        assertEquals("GCD test for positive numbers.", 32, MathUtils.getGcdEuclid(7648, 74944));

        assertEquals("GCD test for negative numbers.", -1, MathUtils.getGcdEuclid(-2, -5));
        assertEquals("GCD test for negative numbers.", -5, MathUtils.getGcdEuclid(-50, -5));
        assertEquals("GCD test for negative numbers.", -1, MathUtils.getGcdEuclid(-1, -5));
    }

    @Test
    public void testRound()
    {
        assertEquals("Rounding test for positive doubles.", 3.155, MathUtils.roundDouble(3.1545, 3), DELTA);
        assertEquals("Rounding test for positive doubles.", 3.155, MathUtils.roundDouble(3.1546, 3), DELTA);
        assertEquals("Rounding test for positive doubles.", 3.154, MathUtils.roundDouble(3.1544, 3), DELTA);
        assertEquals("Rounding test for negative doubles.", -3.155, MathUtils.roundDouble(-3.1545, 3), DELTA);
        assertEquals("Rounding test for negative doubles.", -3.155, MathUtils.roundDouble(-3.1546, 3), DELTA);
        assertEquals("Rounding test for negative doubles.", -3.154, MathUtils.roundDouble(-3.1544, 3), DELTA);

        assertEquals("Rounding test for positive doubles.", 3, MathUtils.roundDouble(3.1544, 0), DELTA);
        assertEquals("Rounding test for positive doubles.", 4, MathUtils.roundDouble(3.5544, 0), DELTA);
        assertEquals("Rounding test for negative doubles.", -3, MathUtils.roundDouble(-3.1544, 0), DELTA);
        assertEquals("Rounding test for negative doubles.", -4, MathUtils.roundDouble(-3.5544, 0), DELTA);
    }

    @Test
    public void testToRadians()
    {
        assertEquals("Degrees => Radians conversion test.", 0, MathUtils.toRadians(0), DELTA);
        assertEquals("Degrees => Radians conversion test.", 1.570796326794897f, MathUtils.toRadians(90), DELTA);
        assertEquals("Degrees => Radians conversion test.", 3.141592653589793f, MathUtils.toRadians(180), DELTA);
        assertEquals("Degrees => Radians conversion test.", 4.71238898038469f, MathUtils.toRadians(270), DELTA);
        assertEquals("Degrees => Radians conversion test.", 6.283185307179586f, MathUtils.toRadians(360), DELTA);

        assertEquals("Degrees => Radians conversion test for negative numbers.", 0, MathUtils.toRadians(0), DELTA);
        assertEquals("Degrees => Radians conversion test for negative numbers.", -1.570796326794897f, MathUtils.toRadians(-90), DELTA);
        assertEquals("Degrees => Radians conversion test for negative numbers.", -3.141592653589793f, MathUtils.toRadians(-180), DELTA);
        assertEquals("Degrees => Radians conversion test for negative numbers.", -4.71238898038469f, MathUtils.toRadians(-270), DELTA);
        assertEquals("Degrees => Radians conversion test for negative numbers.", -6.283185307179586f, MathUtils.toRadians(-360), DELTA);
    }

    @Test
    public void testXCalculator()
    {
        assertEquals("X calculation for the center.", 112, MathUtils.calculateXPosition(32, 256, "center"));
        assertEquals("X calculation for the left.", 0, MathUtils.calculateXPosition(32, 256, "left"));
        assertEquals("X calculation for the right.", 224, MathUtils.calculateXPosition(32, 256, "right"));
        try
        {
            MathUtils.calculateXPosition(0, 0, "invalid");
            fail("X calculation for an invalid value should throw an IllegalArgumentException");
        }
        catch(IllegalArgumentException ignored) {}
    }

    @Test
    public void testYCalculator()
    {
        assertEquals("Y calculation for the center.", 112, MathUtils.calculateYPosition(32, 256, "middle"));
        assertEquals("Y calculation for the left.", 0, MathUtils.calculateYPosition(32, 256, "top"));
        assertEquals("Y calculation for the right.", 224, MathUtils.calculateYPosition(32, 256, "bottom"));
        try
        {
            MathUtils.calculateYPosition(0, 0, "invalid");
            fail("Y calculation for an invalid value should throw an IllegalArgumentException");
        }
        catch(IllegalArgumentException ignored) {}
    }

    @Test
    public void testNearest()
    {
        assertEquals("Getting the nearest to 14 value in an array of positive numbers.", 2, MathUtils.getNearest(new int[] {1, 20, 13, 180}, 14));
        assertEquals("Getting the nearest to -50 value in an array of mixed numbers.", 1, MathUtils.getNearest(new int[] {1, -20, 13, -180}, -50));
        assertEquals("Getting the nearest to 2 value in an array of negative numbers.", 0, MathUtils.getNearest(new int[] {-1, -20, -13, -180}, 2));
    }
}
