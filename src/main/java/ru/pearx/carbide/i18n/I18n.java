/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.i18n;

import ru.pearx.carbide.OtherUtils;

import java.util.List;
import java.util.Properties;

/*
 * Created by mrAppleXZ on 03.08.17 11:26.
 */

/**
 * The internationalization.
 */
public class I18n
{
    private II18nLoader loader;
    private String defaultLocale;

    private String currentLocale;
    private Properties langMap;
    private Properties defaultLangMap;

    /**
     * Creates a new {@link I18n} object.
     *
     * @param loader        The loader.
     * @param defaultLocale Default locale. It will be used when the loaded locale doesn't contain needed key.
     */
    public I18n(II18nLoader loader, String defaultLocale)
    {
        this.loader = loader;
        setDefaultLocale(defaultLocale);
    }

    /**
     * Loads a locale.
     *
     * @param locale Locale name.
     */
    public void load(String locale)
    {
        currentLocale = locale;
        langMap = loader.loadLocale(locale);
        if (!locale.equals(getDefaultLocale()))
            defaultLangMap = loader.loadLocale(getDefaultLocale());
        else
            defaultLangMap = null;
    }

    /**
     * Gets an unformatted translated key from the loaded locale. If the loaded locale doesn't contain needed key, a key will be loaded from the default locale. Even if the default locale doesn't contain needed key, this method will return a key itself.
     *
     * @param key Translation key.
     */
    public String get(String key)
    {
        if (langMap != null && langMap.containsKey(key))
            return langMap.getProperty(key);
        if (defaultLangMap != null && !currentLocale.equals(getDefaultLocale()) && defaultLangMap.containsKey(key))
            return defaultLangMap.getProperty(key);
        return key;
    }

    /**
     * Gets a formatted output of {@link I18n#get(String)} method.
     *
     * @param key  Translation key.
     * @param args Arguments for {@link String#format(String, Object...)}
     */
    public String format(String key, Object... args)
    {
        return String.format(get(key), args);
    }

    /**
     * Gets the available locales.
     */
    public List<Locale> getAvailable()
    {
        return loader.getAvailableLocales();
    }

    /**
     * Gets the I18n loader.
     */
    public II18nLoader getLoader()
    {
        return loader;
    }


    /**
     * Gets the default locale. It will be used when the loaded locale doesn't contain needed key.
     */
    public String getDefaultLocale()
    {
        return defaultLocale;
    }

    /**
     * Sets the default locale. It will be used when the loaded locale doesn't contain needed key.
     *
     * @param defaultLocale Default locale name.
     */
    public void setDefaultLocale(String defaultLocale)
    {
        this.defaultLocale = defaultLocale;
    }

    public String getCurrentLocale()
    {
        return currentLocale;
    }

    public void loadSystemLocale(boolean lowercase)
    {
        String s = OtherUtils.getCurrentLocale();
        if (lowercase)
            s = s.toLowerCase();
        load(s);
    }
}
