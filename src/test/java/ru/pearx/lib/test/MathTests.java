package ru.pearx.lib.test;

import org.junit.Assert;
import org.junit.Test;
import ru.pearx.lib.math.MathUtils;

/*
 * Created by mrAppleXZ on 04.07.17 10:59.
 */
public class MathTests
{
    @Test
    public void isEven()
    {
        Assert.assertEquals("isEven(15) should return false", false, MathUtils.isEven(15));
        Assert.assertEquals("isEven(30) should return true", true, MathUtils.isEven(30));
    }

    @Test
    public void gettingAverage()
    {
        Assert.assertEquals("getAverage(100, 200, 300) should return 200", 200, MathUtils.getAverage(100, 200, 300));
        Assert.assertEquals("getAverage(-20, -20, -50) should return -30", -30, MathUtils.getAverage(-20, -20, -50));

        Assert.assertEquals("getAverageDouble(13.2, 16.5, 6.9) should return 12.2", 12.2d, MathUtils.getAverageDouble(13.2d, 16.5d, 6.9d), 0.001d);
        Assert.assertEquals("getAverageDouble(-13.2, -16.5, -6.9) should return -12.2", -12.2d, MathUtils.getAverageDouble(-13.2d, -16.5d, -6.9d), 0.001d);
    }

    @Test
    public void gettingNearestPowerOf()
    {
        Assert.assertEquals("getNearestPowerOf(117, 2) should return 128", 128, MathUtils.getNearestPowerOf(117, 2));
        Assert.assertEquals("getNearestPowerOf(228, 2) should return 256", 256, MathUtils.getNearestPowerOf(228, 2));
    }

    @Test
    public void gettingGreatestCommonDivider()
    {
        Assert.assertEquals("getGcdEuclid(28, 12) should return 4", 4, MathUtils.getGcdEuclid(28, 12));
        Assert.assertEquals("getGcdEuclid(-30, -10) should return -10", -10, MathUtils.getGcdEuclid(-30, -10));
    }
}
