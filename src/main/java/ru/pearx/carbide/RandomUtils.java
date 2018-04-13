/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

import java.util.Random;

/*
 * Created by mrAppleXZ on 04.07.17 12:10.
 */

/**
 * Utils related to RNG.
 */
public class RandomUtils
{
    /**
     * Generates a random character in "alphabet".
     * @param rand {@link Random} instance.
     * @param alphabet Alphabet string.
     * @return A random character in "alphabet".
     */
    public static char genChar(Random rand, String alphabet)
    {
        return alphabet.charAt(rand.nextInt(alphabet.length()));
    }

    /**
     * Generates a random English letter in lowercase.
     * @param rand {@link Random} instance.
     * @return A random letter.
     */
    public static char genLetter(Random rand)
    {
        return genChar(rand, Alphabets.ENGLISH);
    }

    /**
     * Generates a random symbol.
     * @param rand {@link Random} instance.
     * @return A random symbol.
     */
    public static char genSymbol(Random rand)
    {
        return genChar(rand, Alphabets.SYMBOLS);
    }

    /**
     * Generates a random digit.
     * @param rand {@link Random} instance.
     * @return A random digit.
     */
    public static char genDigit(Random rand)
    {
        return genChar(rand, Alphabets.DIGITS);
    }

    /**
     * Generates a random character (letter in lowercase, letter in uppercase, digit, symbol if "symbols" is true).
     * @param rand {@link Random} instance.
     * @return A random character.
     */
    public static char genChar(Random rand, boolean symbols)
    {
        return genChar(rand, symbols ? Alphabets.ENGLISH_ALL : Alphabets.ENGLISH_ALL_WO_SYMBOLS);
    }

    /**
     * Generates a random {@link Color}.
     * @param rand {@link Random} instance.
     * @param maxR Max R value (exclusive)
     * @param maxG Max G value (exclusive)
     * @param maxB Max B value (exclusive)
     * @return A random {@link Color}.
     */
    public static Color nextColor(Random rand, int maxR, int maxG, int maxB)
    {
        return Color.fromRGB(rand.nextInt(maxR), rand.nextInt(maxG), rand.nextInt(maxB));
    }

    /**
     * Generates a random {@link Color}.
     * @param rand {@link Random} instance.
     * @param maxA Max A value (exclusive).
     * @param maxR Max R value (exclusive).
     * @param maxG Max G value (exclusive).
     * @param maxB Max B value (exclusive).
     * @return A random {@link Color}.
     */
    public static Color nextColor(Random rand, int maxA, int maxR, int maxG, int maxB)
    {
        return Color.fromARGB(rand.nextInt(maxA), rand.nextInt(maxR), rand.nextInt(maxG), rand.nextInt(maxB));
    }

    /**
     * Generates a random {@link Color}.
     * @param rand {@link Random} instance.
     * @return A random {@link Color}.
     */
    public static Color nextColor(Random rand)
    {
        return nextColor(rand, 256, 256, 256);
    }

    /**
     * Generates a random float within specified bounds.
     * @param min Min value.
     * @param max Max value.
     * @param rand {@link Random} instance.
     */
    public static float nextFloat(float min, float max, Random rand)
    {
        return min + rand.nextFloat() * (max - min);
    }

    /**
     * Generates a random int within specified bounds.
     * @param min Min value (inclusive).
     * @param max Max value (exclusive).
     * @param rand {@link Random} instance.
     */
    public static int nextInt(int min, int max, Random rand)
    {
        return rand.nextInt(max - min) + min;
    }
}
