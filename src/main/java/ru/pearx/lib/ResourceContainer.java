package ru.pearx.lib;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/*
 * Created by mrAppleXZ on 19.11.17 21:39.
 */

/**
 * A container for the resource. May be useful for separating different projects' resources.
 */
public class ResourceContainer
{
    private Class clazz;
    private String root;

    /**
     * Creates a new {@link ResourceContainer} instance with specified
     * @param clazz A class whose {@link ClassLoader} will be used to get the resources.
     * @param root A root path for the resources.
     */
    public ResourceContainer(Class clazz, String root)
    {
        setClazz(clazz);
        setRoot(root);
    }

    /**
     * Gets a class whose {@link ClassLoader} will be used to get the resources.
     */
    public Class getClazz()
    {
        return clazz;
    }

    /**
     * Sets a class whose {@link ClassLoader} will be used to get the resources.
     * @param clazz Class.
     */
    public void setClazz(Class clazz)
    {
        this.clazz = clazz;
    }

    /**
     * Gets a root path of this {@link ResourceContainer}.
     * @return
     */
    public String getRoot()
    {
        return root;
    }

    /**
     * Sets a root path of this {@link ResourceContainer}.
     * @param root Root path.
     */
    public void setRoot(String root)
    {
        this.root = root.endsWith("/") ? root : root + "/";
    }

    /**
     * Gets a resource with specified name as a stream.
     * @param name Path to the resource.
     */
    public InputStream getResource(String name)
    {
        return ResourceUtils.getResource(getRoot() + name, getClazz());
    }

    /**
     * Gets an URL of the resource.
     * @param path Path to the resource.
     */
    public URL getURL(String path)
    {
        return ResourceUtils.getURL(getRoot() + path, getClazz());
    }

    /**
     * Gets a list of the resources in specified path.
     * @param path Path.
     */
    public List<String> getResources(String path)
    {
        return ResourceUtils.getResources(getRoot() + path, getClazz());
    }
}
