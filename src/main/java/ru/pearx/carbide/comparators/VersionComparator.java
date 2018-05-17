package ru.pearx.carbide.comparators;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by mrAppleXZ on 17.05.18 16:24.
 */
public enum VersionComparator implements Comparator<String>
{
    INSTANCE;

    public static int compareVersions(String a, String b)
    {
        return INSTANCE.compare(a, b);
    }

    private static final Pattern PATTERN = Pattern.compile("(\\d+)|([A-Za-z]+)");

    public int compare(String a, String b)
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
                    result = Integer.compare(aString.compareTo(bString), 0);
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
}
