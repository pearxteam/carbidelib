/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

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
        if (a.equals(b))
            return 0;

        Matcher matA = PATTERN.matcher(a);
        Matcher matB = PATTERN.matcher(b);

        for (boolean foundA = matA.find(), foundB = matB.find(); foundA || foundB; foundA = matA.find(), foundB = matB.find())
        {
            String aNumber = null;
            String aString = null;
            String bNumber = null;
            String bString = null;
            if (foundA)
            {
                aNumber = matA.group(1);
                aString = matA.group(2);
            }
            if (foundB)
            {
                bNumber = matB.group(1);
                bString = matB.group(2);
            }
            int result;
            //both segments are numbers
            if (aNumber != null && bNumber != null)
            {
                result = Integer.compare(Integer.parseInt(aNumber), Integer.parseInt(bNumber));
            }
            //both segments are strings
            else if (aString != null && bString != null)
            {
                result = aString.compareToIgnoreCase(bString);
            }
            else
            {
                //<number> <string/none> || <number/none> <string>
                if(aNumber != null || bString != null)
                    result = 1;
                else
                    result = -1;
            }
            if (result != 0)
                return result;
        }
        return 0;
    }
}