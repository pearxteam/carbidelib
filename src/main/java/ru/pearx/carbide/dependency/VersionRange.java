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

    public VersionRange()
    {
    }

    public static VersionRange within(@Nullable String from, boolean fromInclusive, @Nullable String to, boolean toInclusive)
    {
        VersionRange range = new VersionRange();
        range.setFrom(from);
        range.setFromInclusive(fromInclusive);
        range.setTo(to);
        range.setToInclusive(toInclusive);
        return range;
    }

    public static VersionRange from(@Nullable String from, boolean fromInclusive)
    {
        VersionRange range = new VersionRange();
        range.setFrom(from);
        range.setFromInclusive(fromInclusive);
        return range;
    }

    public static VersionRange to(@Nullable String to, boolean toInclusive)
    {
        VersionRange range = new VersionRange();
        range.setTo(to);
        range.setToInclusive(toInclusive);
        return range;
    }

    @Nullable
    public String getFrom()
    {
        return from;
    }

    public void setFrom(@Nullable String from)
    {
        this.from = from;
    }

    @Nullable
    public String getTo()
    {
        return to;
    }

    public void setTo(@Nullable String to)
    {
        this.to = to;
    }

    public boolean isFromInclusive()
    {
        return fromInclusive;
    }

    public void setFromInclusive(boolean fromInclusive)
    {
        this.fromInclusive = fromInclusive;
    }

    public boolean isToInclusive()
    {
        return toInclusive;
    }

    public void setToInclusive(boolean toInclusive)
    {
        this.toInclusive = toInclusive;
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
}
