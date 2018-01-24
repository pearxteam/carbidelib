package ru.pearx.lib;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Created by mrAppleXZ on 03.07.17 11:43.
 */

/**
 * Some PearXLib utils related to getting directories' paths.
 */
public class D
{
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
