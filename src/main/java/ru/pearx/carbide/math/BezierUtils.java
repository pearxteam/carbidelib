/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.math;

/*
 * Created by mrAppleXZ on 11.02.18 10:42.
 */
public final class BezierUtils
{
    private BezierUtils(){}

    public static float[] getBezier2dPoint(float time, float x0, float y0, float x1, float y1, float x2, float y2)
    {
        float omt = (1 - time);
        return new float[]
                {
                        omt * (omt * x0 + time * x1) + time * (omt * x1 + time * x2),
                        omt * (omt * y0 + time * y1) + time * (omt * y1 + time * y2)
                };
    }

    public static float[][] getBezier2dPoints(float dt, float x0, float y0, float x1, float y1, float x2, float y2)
    {
        int size = (int)Math.ceil(1 / dt) + 1;
        float[][] pts = new float[size][2];
        for(int i = 0; i < size; i++)
        {
            pts[i] = getBezier2dPoint(i * dt, x0, y0, x1, y1, x2, y2);
        }
        return pts;
    }
}
