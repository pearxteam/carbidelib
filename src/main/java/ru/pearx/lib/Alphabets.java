package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 03.07.17 11:40.
 */
public class Alphabets
{
    public static final String ENGLISH = "abcdefghijklmnopqrstuvwxyz";
    public static final String ENGLISH_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()_+\"№;%:?*()=-.,/\\|'";

    public static final String ENGLISH_ALL_WO_SYMBOLS = ENGLISH + ENGLISH_UPPER + DIGITS;
    public static final String ENGLISH_ALL = ENGLISH_ALL_WO_SYMBOLS + SYMBOLS;
}
