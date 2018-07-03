package ru.pearx.carbide.color

/*
 * Created by mrAppleXZ on 03.07.18 9:03
 */
interface ColorSingleStored : Color
{
    override val alpha: Int
        get() = (argb shr Color.ALPHA_SHIFT) and Color.MASK
    override val red: Int
        get() = (argb shr Color.RED_SHIFT) and Color.MASK
    override val green: Int
        get() = (argb shr Color.GREEN_SHIFT) and Color.MASK
    override val blue: Int
        get() = argb and Color.MASK
}