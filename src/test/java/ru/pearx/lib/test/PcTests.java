package ru.pearx.lib.test;

import com.sun.management.OperatingSystemMXBean;
import org.junit.Assert;
import org.junit.Test;
import ru.pearx.lib.PcUtils;

/*
 * Created by mrAppleXZ on 04.07.17 12:00.
 */
public class PcTests
{
    @Test
    public void gettingOs()
    {
        String os = PcUtils.getOs();
        Assert.assertNotNull("getOs() not null", os);
        System.out.println("Your OS: " + os);
    }

    @Test
    public void gettingRam()
    {
        OperatingSystemMXBean bean = PcUtils.getOsMXBean();
        Assert.assertNotNull("PcUtils.getOsMXBean() not null", bean);
        System.out.println("Total RAM: " + (bean.getTotalPhysicalMemorySize() / 1024 / 1024) + "Mb");
        System.out.println("Used RAM: " + (bean.getCommittedVirtualMemorySize() / 1024 / 1024) + "Mb");
        System.out.println("Free RAM: " + ((bean.getTotalPhysicalMemorySize() - bean.getCommittedVirtualMemorySize()) / 1024 / 1024) + "Mb");
    }
}
