/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.dependency;

/*
 * Created by mrAppleXZ on 18.05.18 19:54.
 */
public class Dependency
{
    private String name;
    private VersionRange versionRange;
    private DependencyType type;
    private LoadingOrder order;

    public Dependency(String name, VersionRange versionRange, DependencyType type, LoadingOrder order)
    {
        this.name = name;
        this.versionRange = versionRange;
        this.type = type;
        this.order = order;
    }

    public String getName()
    {
        return name;
    }

    public VersionRange getVersionRange()
    {
        return versionRange;
    }

    public DependencyType getType()
    {
        return type;
    }

    public LoadingOrder getOrder()
    {
        return order;
    }

    public String toString()
    {
        return "Dependency{" +
                "name='" + getName()+ '\'' +
                ", versionRange=" + getVersionRange() +
                ", type=" + getType() +
                ", order=" + getOrder() +
                '}';
    }
}
