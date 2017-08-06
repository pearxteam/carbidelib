package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 04.07.17 14:48.
 */

import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Random PearXLib utils.
 */
public class PXL
{
    /**
     * Encodes a URL using UTF-8.
     * @param url Decoded URL.
     * @return Encoded URL.
     */
    public static String encodeUrl(String url)
    {
        try
        {
            return URLEncoder.encode(url, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Decodes a URL using UTF-8
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
     * Opens an URL using default browser.
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

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
    }
}
