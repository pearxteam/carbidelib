/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

import java.lang.management.ManagementFactory;

/*
 * Created by mrAppleXZ on 03.07.17 11:52.
 */
public final class PcUtils
{
    private PcUtils(){}

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
