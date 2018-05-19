/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

/*
 * Created by mrAppleXZ on 03.07.17 11:40.
 */

/**
 * A class that contain the lists of characters. May be useful for RNG, for instance.
 */
public final class Alphabets
{
    private Alphabets(){}
    /**
     * a-z
     */
    public static final String ENGLISH = "abcdefghijklmnopqrstuvwxyz";
    /**
     * A-Z
     */
    public static final String ENGLISH_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 0-9
     */
    public static final String DIGITS = "0123456789";
    /**
     * !@#$%^&*()_+"№;%:?*()=-.,/\|'
     */
    public static final String SYMBOLS = "!@#$%^&*()_+\"№;%:?*()=-.,/\\|'";

    /**
     * a-z + A-Z + 0-9
     */
    public static final String ENGLISH_ALL_WO_SYMBOLS = ENGLISH + ENGLISH_UPPER + DIGITS;

    /**
     * a-z + A-Z + 0-9 + symbols
     */
    public static final String ENGLISH_ALL = ENGLISH_ALL_WO_SYMBOLS + SYMBOLS;
}
