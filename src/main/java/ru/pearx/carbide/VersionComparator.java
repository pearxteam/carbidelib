package ru.pearx.carbide;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by mrAppleXZ on 17.05.18 16:24.
 */
public final class VersionComparator
{
    private static final Pattern PATTERN = Pattern.compile("(\\d+)|([A-Za-z]+)");

    private VersionComparator() {}

    public static int compare(String a, String b)
    {
        if(a.equals(b))
            return 0;

        Matcher matA = PATTERN.matcher(a);
        Matcher matB = PATTERN.matcher(b);

        for(boolean foundA = matA.find(), foundB = matB.find(); foundA || foundB; foundA = matA.find(), foundB = matB.find())
        {
            if(foundA && !foundB)
                return 1;
            if(!foundA && foundB)
                return -1;
            else
            {
                String aNumber = matA.group(1);
                String aString = matA.group(2);
                String bNumber = matB.group(1);
                String bString = matB.group(2);
                int result;
                if(aNumber != null && bNumber != null)
                {
                    result = Integer.compare(Integer.parseInt(aNumber), Integer.parseInt(bNumber));
                }
                else if(aString != null && bString != null)
                {
                    result = aString.compareTo(bString);
                }
                else
                {
                    result = aNumber != null ? 1 : -1;
                }
                if(result != 0)
                    return result;
            }
        }
        return 0;
    }

    public static class Comparator implements java.util.Comparator<String>
    {
        @Override
        public int compare(String o1, String o2)
        {
            return VersionComparator.compare(o1, o2);
        }
    }
}
