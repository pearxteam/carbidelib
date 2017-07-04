package ru.pearx.lib;

import java.lang.management.ManagementFactory;
import java.nio.file.FileVisitor;
import java.nio.file.Files;

/*
 * Created by mrAppleXZ on 03.07.17 11:52.
 */
public class PcUtils
{
    /**
     * Gets the OS name.
     * @return OS name.
     */
    public static String getOs()
    {
        return System.getProperty("os.name");
    }

    /**
     * Checks if OS is Windows.
     * @return True if OS is Windows, false otherwise.
     */
    public static boolean isWindows()
    {
        return getOs().toLowerCase().startsWith("windows");
    }

    /**
     * Gets the {@link com.sun.management.OperatingSystemMXBean} object.
     * @return OperatingSystemMXBean object.
     */
    public static com.sun.management.OperatingSystemMXBean getOsMXBean()
    {
        return (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
    }
}
