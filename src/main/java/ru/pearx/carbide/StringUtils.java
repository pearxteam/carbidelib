/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * Created by mrAppleXZ on 13.04.18 18:19.
 */
public final class StringUtils
{
    private StringUtils(){}

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

    public static int parseInt(String s, int def)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException ex)
        {
            return def;
        }
    }
}
