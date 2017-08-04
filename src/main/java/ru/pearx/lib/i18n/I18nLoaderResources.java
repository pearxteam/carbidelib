package ru.pearx.lib.i18n;

import ru.pearx.lib.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
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
    private List<String> paths = new ArrayList<>();

    @Override
    public Properties loadLocale(String locale)
    {
        for(String path : paths)
        {
            try(InputStreamReader rdr = new InputStreamReader(ResourceUtils.getResource(path + (path.endsWith("/") ? "" : "/") + locale + ".properties"), "UTF-8"))
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
        for(String path : getPaths())
        {
            try(InputStreamReader rdr = new InputStreamReader(ResourceUtils.getResource(path + (path.endsWith("/") ? "" : "/") + "langs.properties"), "UTF-8"))
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

    public List<String> getPaths()
    {
        return paths;
    }
}
