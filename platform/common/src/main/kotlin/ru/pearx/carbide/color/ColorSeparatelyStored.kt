package ru.pearx.carbide.color

/*
 * Created by mrAppleXZ on 03.07.18 8:51
 */
interface ColorSeparatelyStored : Color
{
    override val argb: Int
        get() = (alpha shl Color.ALPHA_SHIFT) or (red shl Color.RED_SHIFT) or (green shl Color.GREEN_SHIFT) or blue
}