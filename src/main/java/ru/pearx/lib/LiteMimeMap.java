package ru.pearx.lib;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by mrAppleXZ on 09.08.17 7:22.
 */

//todo make something not ugly as this
/**
 * A light MIME types map.
 */
public class LiteMimeMap
{
    /**
     * The MIME Type | Extensions map.
     */
    public static Map<String, String[]> map = new HashMap<>();

    static
    {
        map.put("image/bmp", new String[] {"bmp", "dib"});
        map.put("image/svg+xml-compressed", new String[] {"svgz"});
        map.put("image/jpeg", new String[] {"jpg", "jpeg", "jpe"});
        map.put("image/wmf", new String[] {"wmf"});
        map.put("image/svg+xml", new String[] {"svg"});
        map.put("image/x-jng", new String[] {"jng"});
        map.put("image/jp2", new String[] {"jp2", "jpf", "jpx"});
        map.put("image/x-portable-bitmap", new String[] {"pbm"});
        map.put("image/x-portable-graymap", new String[] {"pgm"});
        map.put("image/webp", new String[] {"webp"});
        map.put("image/x-webp", new String[] {"webp"});
        map.put("image/cgm", new String[] {"cgm"});
        map.put("image/x-rgb", new String[] {"rgb"});
        map.put("image/png", new String[] {"png"});
        map.put("image/x-portable-anymap", new String[] {"pnm"});
        map.put("image/x-tga", new String[] {"tga", "tpic", "vda", "icb", "vst"});
        map.put("image/rle", new String[] {"rle"});
        map.put("image/x-portable-pixmap", new String[] {"ppm"});
        map.put("image/tiff", new String[] {"tif", "tiff"});
        map.put("image/vnd.adobe.photoshop", new String[] {"psd"});
        map.put("image/x-xbitmap", new String[] {"xbm"});
        map.put("image/vnd.microsoft.icon", new String[] {"ico"});
        map.put("image/x-xcf", new String[] {"xcf"});
        map.put("image/x-compressed-xcf", new String[] {"xcf.gz"});
        map.put("image/gif", new String[] {"gif"});
        map.put("image/x-win-bitmap", new String[] {"cur"});
        map.put("image/x-exr", new String[] {"exr"});
        map.put("image/x-quicktime", new String[] {"qtif", "qif"});
        map.put("image/x-icns", new String[] {"icns"});
        map.put("image/x-xpixmap", new String[] {"xpm"});
    }

    /**
     * Gets a MIME type for the specified filename.
     * @param name Input filename.
     */
    public static String getMimeForFilename(String name)
    {
        for(Map.Entry<String, String[]> entr : map.entrySet())
        {
            for(String ext : entr.getValue())
            {
                //don't create a new string here.
                if(name.endsWith(ext) && name.charAt(name.length() - ext.length() - 1) == '.')
                    return entr.getKey();
            }
        }
        return "application/octet-stream";
    }
}
