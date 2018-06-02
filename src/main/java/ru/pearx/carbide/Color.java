/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

/*
 * Created by mrAppleXZ on 16.08.17 19:53.
 */

/**
 * An ARGB color.
 */
public class Color
{
    private int argb;

    /**
     * Creates an ARGB color from the RGB integers. Alpha value will be "255".
     * @param r Red color. 0-255.
     * @param g Green color. 0-255.
     * @param b Blue color. 0-255.
     */
    public static Color fromRGB(int r, int g, int b)
    {
        return fromARGB(255, r, g, b);
    }

    /**
     * Creates an ARGB color from RGB integers.
     * @param a Alpha. 0-255
     * @param r Red color. 0-255
     * @param g Green color. 0-255
     * @param b Blue color. 0-255
     */
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

    /**
     * Creates an ARGB color from a flattened ARGB integer.
     * @param argb A flattened ARGB integer.
     */
    public static Color fromARGB(int argb)
    {
        Color col = new Color();
        col.setARGB(argb);
        return col;
    }

    /**
     * Creates an ARGB color from a flattened RGB integer. Alpha value will be "255".
     * @param rgb A flattened RGB or ARGB integer.
     */
    public static Color fromRGB(int rgb)
    {
        Color col = new Color();
        col.setRGB(rgb);
        return col;
    }

    /**
     * Gets an ARGB value of the color.
     */
    public int getARGB()
    {
        return argb;
    }

    /**
     * Sets an ARGB value of the color.
     */
    public void setARGB(int argb)
    {
        this.argb = argb;
    }

    /**
     * Sets an RGB value for the color. Alpha will be "255".
     */
    public void setRGB(int rgb)
    {
        setARGB(rgb | 0xFF000000);
    }

    /**
     * Gets an alpha value of the color.
     */
    public int getAlpha()
    {
        return (getARGB() >> 24) & 0xFF;
    }

    /**
     * Gets a red value of the color.
     */
    public int getRed()
    {
        return (getARGB() >> 16) & 0xFF;
    }

    /**
     * Gets a green value of the color.
     */
    public int getGreen()
    {
        return (getARGB() >> 8) & 0xFF;
    }

    /**
     * Gets a blue value of the color.
     */
    public int getBlue()
    {
        return getARGB() & 0xFF;
    }

    public float getRedCoefficient()
    {
        return getRed() / 255F;
    }

    public float getGreenCoefficient()
    {
        return getGreen() / 255F;
    }

    public float getBlueCoefficient()
    {
        return getBlue() / 255F;
    }

    public float getAlphaCoefficient()
    {
        return getAlpha() / 255F;
    }

    /**
     * Converts this {@link Color} to the JavaFX {@link javafx.scene.paint.Color}.
     * @return
     */
    public javafx.scene.paint.Color toJavaFX()
    {
        return javafx.scene.paint.Color.rgb(getRed(), getGreen(), getBlue(), getAlpha() / 255F);
    }
}
