package ru.pearx.lib;

import java.lang.management.ManagementFactory;
import java.nio.file.FileVisitor;
import java.nio.file.Files;

/*
 * Created by mrAppleXZ on 03.07.17 11:52.
 */
public class PcUtils
{
    public static String getOs()
    {
        return System.getProperty("os.name");
    }

    public static boolean isWindows()
    {
        return getOs().toLowerCase().startsWith("windows");
    }

    public static com.sun.management.OperatingSystemMXBean getOsMXBean()
    {
        return (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
    }
}
