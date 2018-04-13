/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by mrAppleXZ on 03.07.17 13:12.
 */
/**
 * Wrapper for /proc/meminfo on Unix-based systems.
 */
public class MemInfo
{
    private List<String> content;

    public MemInfo()
    {
        update();
    }

    /**
     * Updates the cached contents of /proc/meminfo.
     */
    public void update()
    {
        try
        {
            content = Files.readAllLines(Paths.get("/proc/meminfo"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Gets a value from cached /proc/meminfo.
     * @param what Value name.
     * @return Value.
     */
    public long get(String what)
    {
        Pattern pat = Pattern.compile("^" + what + ":\\s+(\\d+)");
        for(String s : content)
        {
            Matcher mat = pat.matcher(s);
            if(mat.find())
            {
                return Long.parseLong(mat.group(1));
            }
        }
        return -1;
    }
}
