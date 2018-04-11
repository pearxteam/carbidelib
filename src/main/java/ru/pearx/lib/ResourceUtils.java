package ru.pearx.lib;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
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
     * Gets all the resource names in the given path.
     * @param path Resources path.
     * @param ldr A ClassLoader used to get the resource names.
     */
    public static List<String> getResources(String path, ClassLoader ldr)
    {
        List<String> lst = new ArrayList<>();
        try (Scanner scan = new Scanner(ldr.getResourceAsStream(path)))
        {
            while(scan.hasNext())
            {
                lst.add(scan.next());
            }
        }
        return lst;
    }

    public static List<URL> getClasses(String path, ClassLoader ldr) throws IOException
    {
        ldr.getResources(path);
        return null;
    }
}
