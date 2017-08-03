package ru.pearx.lib;

import java.io.IOException;
import java.io.InputStream;
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
     */
    public static InputStream getResource(String path)
    {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    /**
     * Gets all the resource names in the given path.
     * @param path Resources path.
     */
    public static List<String> getResources(String path)
    {
        List<String> lst = new ArrayList<>();
        try (Scanner scan = new Scanner(getResource(path)))
        {
            while(scan.hasNext())
            {
                lst.add(scan.next());
            }
        }
        return lst;
    }
}
