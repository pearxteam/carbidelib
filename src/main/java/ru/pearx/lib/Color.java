package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 16.08.17 19:53.
 */
public class Color
{
    private byte red;
    private byte green;
    private byte blue;
    private byte alpha;

    public Color(byte red, byte green, byte blue, byte alpha)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public static Color fromRGBA(int rgba)
    {
        byte a = (byte)(rgba >> 24 & 255);
        byte r = (byte)(rgba >> 16 & 255);
        byte g = (byte)(rgba >> 8 & 255);
        byte b = (byte)(rgba & 255);
        return new Color(r, g, b, a);
    }

    public static Color fromRGB(int rgb)
    {
        Color col = Color.fromRGBA(rgb);
        col.setAlpha(255);
        return col;
    }

    public byte getRed()
    {
        return red;
    }

    public void setRed(byte red)
    {
        this.red = red;
    }

    public byte getGreen()
    {
        return green;
    }

    public void setGreen(byte green)
    {
        this.green = green;
    }

    public byte getBlue()
    {
        return blue;
    }

    public void setBlue(byte blue)
    {
        this.blue = blue;
    }

    public byte getAlpha()
    {
        return alpha;
    }

    public void setAlpha(byte alpha)
    {
        this.alpha = alpha;
    }

    public void setRed(int red)
    {
        setRed((byte)red);
    }

    public void setGreen(int green)
    {
        setGreen((byte)green);
    }

    public void setBlue(int blue)
    {
        setBlue((byte)blue);
    }

    public void setAlpha(int alpha)
    {
        setAlpha((byte)alpha);
    }
}
