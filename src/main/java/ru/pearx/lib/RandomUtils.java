package ru.pearx.lib;

import java.util.Random;

/*
 * Created by mrAppleXZ on 04.07.17 12:10.
 */

/**
 * PearXLib utils related to RNG.
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
}
