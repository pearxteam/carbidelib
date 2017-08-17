package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 16.08.17 19:53.
 */

/**
 * An ARGB color.
 */
public class Color
{
    private int argb;

    protected Color()
    {

    }

    public static Color fromARGB(int argb)
    {
        Color col = new Color();
        col.setARGB(argb);
        return col;
    }

    public static Color fromRGB(int rgb)
    {
        Color col = new Color();
        col.setRGB(rgb);
        return col;
    }

    public int getARGB()
    {
        return argb;
    }

    public void setARGB(int argb)
    {
        this.argb = argb;
    }

    public void setRGB(int rgb)
    {
        setARGB(rgb | 0xFF000000);
    }

    public int getAlpha()
    {
        return (getARGB() >> 24) & 0xFF;
    }

    public int getRed()
    {
        return (getARGB() >> 16) & 0xFF;
    }

    public int getGreen()
    {
        return (getARGB() >> 8) & 0xFF;
    }

    public int getBlue()
    {
        return getARGB() & 0xFF;
    }
}
