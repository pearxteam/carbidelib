package ru.pearx.lib.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import ru.pearx.lib.PcUtils;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrAppleXZ on 03.07.17 12:49.
 */
public class TestRunner
{
    public static void main(String... args)
    {
        List<Result> lst = new ArrayList<>();
        lst.add(JUnitCore.runClasses(MathTests.class));
        lst.add(JUnitCore.runClasses(PcTests.class));

        for(Result res : lst)
        {
            for(Failure fail : res.getFailures())
            {
                System.out.println(fail.toString());
            }
        }
    }
}
