/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

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
    private ClassLoader ldr;
    private String root;

    /**
     * Creates a new {@link ResourceContainer} instance with specified
     * @param ldr A {@link ClassLoader} that will be used to get the resources.
     * @param root A root path for the resources.
     */
    public ResourceContainer(ClassLoader ldr, String root)
    {
        setClassLoader(ldr);
        setRoot(root);
    }

    /**
     * Gets a {@link ClassLoader} that will be used to get the resources.
     */
    public ClassLoader getClassLoader()
    {
        return ldr;
    }

    /**
     * Sets a {@link ClassLoader} that will be used to get the resources.
     * @param ldr ClassLoader.
     */
    public void setClassLoader(ClassLoader ldr)
    {
        this.ldr = ldr;
    }

    /**
     * Gets a root path of this {@link ResourceContainer}.
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
        return ldr.getResourceAsStream(getRoot() + name);
    }

    /**
     * Gets an URL of the resource.
     * @param path Path to the resource.
     */
    public URL getURL(String path)
    {
        return ldr.getResource(getRoot() + path);
    }

    /**
     * Gets a list of the resources in specified path.
     * @param path Path.
     */
    public List<String> getResources(String path)
    {
        return ResourceUtils.getResources(getRoot() + path, getClassLoader());
    }
}
