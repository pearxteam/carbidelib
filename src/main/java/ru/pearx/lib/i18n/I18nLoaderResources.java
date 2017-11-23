package ru.pearx.lib.i18n;

import ru.pearx.lib.ResourceContainer;
import ru.pearx.lib.ResourceUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 * Created by mrAppleXZ on 03.08.17 22:07.
 */

/**
 * An I18n loader that loads the locales from resources.
 */
public class I18nLoaderResources implements II18nLoader
{
    private List<ResourceContainer> containers = new ArrayList<>();

    @Override
    public Properties loadLocale(String locale)
    {
        for(ResourceContainer cont : getContainers())
        {
            try(InputStreamReader rdr = new InputStreamReader(cont.getResource(locale + ".properties"), "UTF-8"))
            {
                Properties props = new Properties();
                props.load(rdr);
                return props;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return new Properties();
    }

    @Override
    public List<Locale> getAvailableLocales()
    {
        List<String> already = new ArrayList<>();
        List<Locale> lst = new ArrayList<>();
        for(ResourceContainer cont : getContainers())
        {
            try(InputStreamReader rdr = new InputStreamReader(cont.getResource("langs.properties"), "UTF-8"))
            {
                Properties data = new Properties();
                data.load(rdr);
                for(Map.Entry<Object, Object> entr : data.entrySet())
                {
                    if(!already.contains(entr.getKey().toString()))
                    {
                        lst.add(new Locale(entr.getKey().toString(), entr.getValue().toString()));
                        already.add(entr.getKey().toString());
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return lst;
    }

    public List<ResourceContainer> getContainers()
    {
        return containers;
    }
}
