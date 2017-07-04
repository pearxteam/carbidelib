package ru.pearx.lib;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Created by mrAppleXZ on 03.07.17 11:43.
 */
public class D
{
    public static Path getHome()
    {
        return Paths.get(System.getProperty("user.home"));
    }

    public static Path getPearX()
    {
        return getHome().resolve(PcUtils.isWindows() ? "PearX" : ".pearx");
    }
}
