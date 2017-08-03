package ru.pearx.lib.i18n;

/*
 * Created by mrAppleXZ on 03.08.17 11:03.
 */

/**
 * An object for a locale.
 */
public class Locale
{
    private String displayName;
    private String locale;

    /**
     * Creates a new locale object.
     * @param locale Locale name. For example, "en".
     * @param displayName Locale display name. For example, "English".
     */
    public Locale(String locale, String displayName)
    {
        this.locale = locale;
        this.displayName = displayName;
    }

    /**
     * Gets the display name.
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Gets the locale name.
     */
    public String getLocale()
    {
        return locale;
    }

    @Override
    public String toString()
    {
        return getLocale() + " (" + getDisplayName() + ")";
    }
}
