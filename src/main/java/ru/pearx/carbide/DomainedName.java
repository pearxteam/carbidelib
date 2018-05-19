/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide;

import javax.annotation.Nonnull;
import java.util.Objects;

/*
 * Created by mrAppleXZ on 26.04.18 17:09.
 */
public class DomainedName
{
    @Nonnull
    private String domain = "";
    @Nonnull
    private String name = "";

    public DomainedName()
    {
    }

    public DomainedName(@Nonnull String path)
    {
        int pos = path.indexOf(':');
        if(pos > 0)
        {
            setDomain(path.substring(0, pos));
        }
        setName(path.substring(pos + 1));
    }

    public DomainedName(@Nonnull String domain, @Nonnull String name)
    {
        setDomain(domain);
        setName(name);
    }

    @Nonnull
    public String getDomain()
    {
        return domain;
    }

    public void setDomain(@Nonnull String domain)
    {
        this.domain = domain;
    }

    @Nonnull
    public String getName()
    {
        return name;
    }

    public void setName(@Nonnull String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainedName that = (DomainedName) o;
        return Objects.equals(getDomain(), that.getDomain()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getDomain(), getName());
    }

    @Override
    public String toString()
    {
        return getDomain() + ":" + getName();
    }
}
