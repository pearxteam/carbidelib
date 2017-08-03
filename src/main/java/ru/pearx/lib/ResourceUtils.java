package ru.pearx.lib;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Created by mrAppleXZ on 03.08.17 17:23.
 */
public class ResourceUtils
{
    public static InputStream getResource(String path) throws IOException
    {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public static List<String> getResources(String path) throws IOException
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
