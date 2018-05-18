package ru.pearx.carbide.tests;

import org.junit.Test;
import ru.pearx.carbide.dependency.VersionRange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 * Created by mrAppleXZ on 18.05.18 19:01.
 */
public class VersionRangeTest
{
    @Test
    public void testBoth()
    {
        VersionRange range1 = VersionRange.within("1.5", true, "1.6", true);
        assertTrue(range1.isVersionWithinRange("1.5"));
        assertTrue(range1.isVersionWithinRange("1.5.6.5"));
        assertTrue(range1.isVersionWithinRange("1.6"));
        assertFalse(range1.isVersionWithinRange("1.4.9"));
        assertFalse(range1.isVersionWithinRange("1.6.1"));
        assertFalse(range1.isVersionWithinRange("0"));

        VersionRange range2 = VersionRange.within("1.5", false, "1.6", true);
        assertFalse(range2.isVersionWithinRange("1.5"));
        assertTrue(range2.isVersionWithinRange("1.5.1"));
        assertTrue(range2.isVersionWithinRange("1.6"));

        VersionRange range3 = VersionRange.within("1.5", false, "1.6", false);
        assertFalse(range3.isVersionWithinRange("1.5"));
        assertTrue(range3.isVersionWithinRange("1.5.1"));
        assertFalse(range3.isVersionWithinRange("1.6"));
    }

    @Test
    public void testFrom()
    {
        VersionRange range1 = VersionRange.from("1.5", true);
        assertTrue(range1.isVersionWithinRange("1.5"));
        assertTrue(range1.isVersionWithinRange("1.5.6.5"));
        assertTrue(range1.isVersionWithinRange("1.6"));
        assertFalse(range1.isVersionWithinRange("1.4.9"));
        assertTrue(range1.isVersionWithinRange("2"));
        assertFalse(range1.isVersionWithinRange("0"));

        VersionRange range2 = VersionRange.from("1.5", false);
        assertFalse(range2.isVersionWithinRange("1.5"));
        assertTrue(range2.isVersionWithinRange("1.5.7"));
    }

    @Test
    public void testTo()
    {
        VersionRange range1 = VersionRange.to("1.6", true);
        assertTrue(range1.isVersionWithinRange("1.5"));
        assertTrue(range1.isVersionWithinRange("1.5.6.5"));
        assertTrue(range1.isVersionWithinRange("1.6"));
        assertFalse(range1.isVersionWithinRange("1.7"));
        assertFalse(range1.isVersionWithinRange("2"));
        assertTrue(range1.isVersionWithinRange("0"));

        VersionRange range2 = VersionRange.to("1.6", false);
        assertFalse(range2.isVersionWithinRange("1.6"));
        assertTrue(range2.isVersionWithinRange("1.5.7"));
    }
}
