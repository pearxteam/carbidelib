/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.i18n;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by mrAppleXZ on 04.08.17 19:08.
 */
public abstract class I18nManager
{
    private Map<String, I18n> loadedLocales = new HashMap<>();

    public Map<String, I18n> getMap()
    {
        return loadedLocales;
    }

    public boolean isLoaded(String locale)
    {
        return loadedLocales.containsKey(locale);
    }

    public void load(String locale)
    {
        loadedLocales.put(locale, createI18n(locale));
    }

    public void unload(String locale)
    {
        loadedLocales.remove(locale);
    }

    public I18n get(String locale)
    {
        if(!isLoaded(locale))
            load(locale);
        return loadedLocales.get(locale);
    }

    public abstract I18n createI18n(String locale);
}
