/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Created by mrAppleXZ on 03.07.17 11:43.
 */

/**
 * Some utils related to getting directories' paths.
 */
public final class D
{
    private D(){}
    /**
     * Gets the home directory.
     * @return Home directory path.
     */
    public static Path getHome()
    {
        return Paths.get(System.getProperty("user.home"));
    }

    /**
     * Gets the PearX directory.
     * @return getHome()/PearX on Windows, getHome()/.pearx otherwise.
     */
    public static Path getPearX()
    {
        return getHome().resolve(PcUtils.isWindows() ? "PearX" : ".pearx");
    }

    /**
     * Gets the working directory.
     * @return Working directory path.
     */
    public static Path getWorkingDir()
    {
        return Paths.get(System.getProperty("user.dir"));
    }
}
