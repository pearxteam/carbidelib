/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.i18n;

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
