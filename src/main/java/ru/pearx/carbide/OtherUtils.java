/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

/*
 * Created by mrAppleXZ on 04.07.17 14:48.
 */

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * Various other utilities.
 */
public class OtherUtils
{
    /**
     * Opens an URL using the default browser.
     * @param url URL.
     */
    public static void openUrl(String url)
    {
        if(Desktop.isDesktopSupported())
        {
            try
            {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Copies the {@link InputStream} "in" into the {@link OutputStream} "out".
     * @param in Input Stream.
     * @param out Output Stream.
     * @throws IOException If an error occurs while working with the streams.
     */
    public static void writeStream(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[4096];
        for(int i = in.read(buffer); i > 0; i = in.read(buffer))
        {
            out.write(buffer, 0, i);
        }
    }

    public static String joinArray(String delimiter, String prefix, String postFix, String... strings)
    {
        StringJoiner j = new StringJoiner(delimiter, prefix, postFix);
        for(String s : strings)
            j.add(s);
        return j.toString();
    }

    public static <T> boolean arrayContains(T[] arr, T val)
    {
        for(T t : arr)
            if(val.equals(t))
                return true;
        return false;
    }
}
