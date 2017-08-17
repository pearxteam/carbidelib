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

    public static Color fromRGB(int r, int g, int b)
    {
        return fromARGB(255, r, g, b);
    }

    public static Color fromARGB(int a, int r, int g, int b)
    {
        if(a > 255 || r > 255 || g > 255 || b > 255)
            throw new IllegalArgumentException("One of the values is bigger than 255!");
        if(a < 0 || r < 0 || g < 0 || b < 0)
            throw new IllegalArgumentException("One of the values is less than 0!");
        int i = 0;
        i |= a << 24;
        i |= r << 16;
        i |= g << 8;
        i |= b;
        return Color.fromARGB(i);
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
