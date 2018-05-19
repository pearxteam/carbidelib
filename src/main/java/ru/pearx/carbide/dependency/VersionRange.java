/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.dependency;

import ru.pearx.carbide.comparators.VersionComparator;

import javax.annotation.Nullable;

/*
 * Created by mrAppleXZ on 18.05.18 18:47.
 */
public class VersionRange
{
    @Nullable
    private String from = null;
    private boolean fromInclusive;
    @Nullable
    private String to = null;
    private boolean toInclusive;

    private VersionRange()
    {
    }

    public static VersionRange within(@Nullable String from, boolean fromInclusive, @Nullable String to, boolean toInclusive)
    {
        VersionRange range = new VersionRange();
        range.from = from;
        range.fromInclusive = fromInclusive;
        range.to = to;
        range.toInclusive = toInclusive;
        return range;
    }

    public static VersionRange from(@Nullable String from, boolean fromInclusive)
    {
        VersionRange range = new VersionRange();
        range.from = from;
        range.fromInclusive = fromInclusive;
        return range;
    }

    public static VersionRange to(@Nullable String to, boolean toInclusive)
    {
        VersionRange range = new VersionRange();
        range.to = to;
        range.toInclusive = toInclusive;
        return range;
    }

    public static VersionRange any()
    {
        VersionRange range = new VersionRange();
        return range;
    }

    @Nullable
    public String getFrom()
    {
        return from;
    }

    @Nullable
    public String getTo()
    {
        return to;
    }

    public boolean isFromInclusive()
    {
        return fromInclusive;
    }

    public boolean isToInclusive()
    {
        return toInclusive;
    }

    public boolean isVersionWithinRange(String version)
    {
        // from <(=) version <(=) to
        if(from != null)
        {
            if(!compare(getFrom(), version, isFromInclusive()))
                return false;
        }
        if(to != null)
        {
            return compare(version, getTo(), isToInclusive());
        }
        return true;
    }

    private boolean compare(String a, String b, boolean inclusive)
    {
        int comp = VersionComparator.compareVersions(a, b);
        return (!inclusive && comp < 0) || (inclusive && comp <= 0);
    }

    @Override
    public String toString()
    {
        if(getFrom() == null && getTo() == null)
            return "any";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(getFrom() != null)
        {
            sb.append("from ").append(getFrom()).append(isFromInclusive() ? " (inclusive)" : "");
            flag = true;
        }
        if(getTo() != null)
        {
            if(flag)
                sb.append(" ");
            sb.append("to ").append(getTo()).append(isToInclusive() ? " (inclusive)" : "");
        }
        return sb.toString();
    }
}
