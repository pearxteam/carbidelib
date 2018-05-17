package ru.pearx.carbide.tests;

import org.junit.Test;
import ru.pearx.carbide.comparators.VersionComparator;

import static org.junit.Assert.assertEquals;

/*
 * Created by mrAppleXZ on 17.05.18 21:10.
 */
public class VersionComparatorTest
{
    @Test
    public void testEqualStrings()
    {
        assertEquals(0, VersionComparator.compareVersions("1.2.75675", "1.2.75675"));
    }

    @Test
    public void testEqualVersion()
    {
        assertEquals(0, VersionComparator.compareVersions("1.2.6", "1-2-6"));
        assertEquals(0, VersionComparator.compareVersions("1.2.6b", "1-2-6b"));
    }

    @Test
    public void testUnequalVersion()
    {
        assertEquals(-1, VersionComparator.compareVersions("1.5.1", "1.5.2"));
        assertEquals(1, VersionComparator.compareVersions("1.6.1", "1.5.2"));
        assertEquals(1, VersionComparator.compareVersions("1.5.3", "1.5.a"));
        assertEquals(-1, VersionComparator.compareVersions("1.5.3", "1.5.3.4"));
        assertEquals(1, VersionComparator.compareVersions("1.5.3.1", "1.5.3"));
        assertEquals(1, VersionComparator.compareVersions("1.5.3b", "1.5.3a"));
    }
}
