/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.i18n;

import java.util.List;
import java.util.Properties;

/*
 * Created by mrAppleXZ on 03.08.17 10:59.
 */

/**
 * An interface for all I18n loaders.
 * Loaders are the things that loads the properties for a locale and lists available locales.
 * An example of a loader: {@link I18nLoaderResources}.
 */
public interface II18nLoader
{
    /**
     * Loads the property map for a locale.
     * @param locale A locale.
     * @return Property map.
     */
    Properties loadLocale(String locale);

    /**
     * Returns a list of all the available locales. Can be used for a locale selection a GUI, for example.
     * @return A list.
     */
    List<Locale> getAvailableLocales();
}
