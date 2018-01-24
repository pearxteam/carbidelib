package ru.pearx.lib;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/*
 * Created by mrAppleXZ on 19.11.17 21:39.
 */
public class ResourceContainer
{
    private Class clazz;
    private String root;

    public ResourceContainer(Class clazz, String root)
    {
        setClazz(clazz);
        setRoot(root);
    }

    public Class getClazz()
    {
        return clazz;
    }

    public void setClazz(Class clazz)
    {
        this.clazz = clazz;
    }

    public String getRoot()
    {
        return root;
    }

    public void setRoot(String root)
    {
        this.root = root.endsWith("/") ? root : root + "/";
    }

    public InputStream getResource(String name)
    {
        return ResourceUtils.getResource(getRoot() + name, getClazz());
    }

    public URL getURL(String path)
    {
        return ResourceUtils.getURL(getRoot() + path, getClazz());
    }

    public List<String> getResources(String path)
    {
        return ResourceUtils.getResources(getRoot() + path, getClazz());
    }
}
