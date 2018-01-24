package ru.pearx.lib;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Created by mrAppleXZ on 03.08.17 17:23.
 */

/**
 * The utils that related to resources.
 */
public class ResourceUtils
{
    /**
     * Gets a resource stream.
     * @param path Resource path.
     * @param clazz A class whose {@link ClassLoader} will be used to get the resource.
     */
    public static InputStream getResource(String path, Class clazz)
    {
        return clazz.getClassLoader().getResourceAsStream(path);
    }

    /**
     * Gets an URL of the resource.
     * @param path Path to the resource.
     * @param clazz A class whose {@link ClassLoader} will be used to get the resource.
     */
    public static URL getURL(String path, Class clazz)
    {
        return clazz.getClassLoader().getResource(path);
    }

    /**
     * Gets all the resource names in the given path.
     * @param path Resources path.
     * @param clazz A class whose {@link ClassLoader} will be used to get the resource.
     */
    public static List<String> getResources(String path, Class clazz)
    {
        List<String> lst = new ArrayList<>();
        try (Scanner scan = new Scanner(getResource(path, clazz)))
        {
            while(scan.hasNext())
            {
                lst.add(scan.next());
            }
        }
        return lst;
    }
}
