package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 16.08.17 19:53.
 */

/**
 * An ARGB color.
 */
public class Color
{
    private byte red;
    private byte green;
    private byte blue;
    private byte alpha;


    /**
     * Creates the new {@link Color} instance.
     * @param red Red value.
     * @param green Green value.
     * @param blue Blue value.
     * @param alpha Alpha value.
     */
    public Color(byte red, byte green, byte blue, byte alpha)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }


    /**
     * Creates the new {@link Color} from ARGB.
     * @param argb ARGB value.
     * @return The new {@link Color} instance.
     */
    public static Color fromARGB(int argb)
    {
        byte a = (byte)(argb >> 24 & 255);
        byte r = (byte)(argb >> 16 & 255);
        byte g = (byte)(argb >> 8 & 255);
        byte b = (byte)(argb & 255);
        return new Color(r, g, b, a);
    }

    /**
     * Creates the new {@link Color} from RGB.
     * @param rgb RGB value.
     * @return The new {@link Color} instance.
     */
    public static Color fromRGB(int rgb)
    {
        Color col = Color.fromARGB(rgb);
        col.setAlpha(255);
        return col;
    }

    /**
     * Converts this color to the ARGB int.
     */
    public int toARGB()
    {
        int i = 0;
        i |= getAlpha() << 24;
        i |= getRed() << 16;
        i |= getGreen() << 8;
        i |= getBlue();
        return i;
    }

    /**
     * Converts this color to the RGB int.
     */
    public int toRGB()
    {
        int i = 0;
        i |= getRed() << 16;
        i |= getGreen() << 8;
        i |= getBlue();
        return i;
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
