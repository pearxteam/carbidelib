package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 04.07.17 14:48.
 */

import com.sun.org.apache.regexp.internal.RE;

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
 * Random PearXLib utils.
 */
public class PXL
{
    /**
     * Encodes an URL using UTF-8.
     * @param url Decoded URL.
     * @param spaceAsP20 If true - use "%20" for the space character. If false - use "+" for the space character.
     * @return Encoded URL.
     */
    public static String encodeUrl(String url, boolean spaceAsP20)
    {
        try
        {
            String s = URLEncoder.encode(url, "UTF-8");
            return spaceAsP20 ? s.replace("+", "%20") : s;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Encodes a URL using UTF-8 and "%20" for spaces.
     * @param url Decoded URL.
     * @return Encoded URL.
     */
    public static String encodeUrl(String url)
    {
        return encodeUrl(url, true);
    }

    /**
     * Decodes an URL using UTF-8
     * @param url Encoded URL.
     * @return Decoded URL.
     */
    public static String decodeUrl(String url)
    {
        try
        {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

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
     * Converts a byte array "bts" to a hexadecimal string.
     * @param bts Byte array.
     * @return Hexadecimal string.
     */
    public static String getHexString(byte[] bts)
    {
        StringBuilder sb = new StringBuilder();
        for(byte bt : bts)
        {
            sb.append(String.format("%02x", bt));
        }
        return sb.toString();
    }

    /**
     * Checks whether the "s" is null or an empty string.
     * @param s Input string.
     * @return True if "s" is null or an empty string, otherwise false.
     */
    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
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
}
