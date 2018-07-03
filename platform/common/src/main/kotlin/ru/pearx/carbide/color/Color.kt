package ru.pearx.carbide.color

/*
 * Created by mrAppleXZ on 03.07.18 4:57
 */

interface Color
{
    companion object
    {
        const val ALPHA_SHIFT = 24
        const val RED_SHIFT = 16
        const val GREEN_SHIFT = 8
        const val MASK = 0xFF

        const val MAX_VALUE = 255
        const val MAX_VALUE_FLOAT = 255F
    }

    val argb: Int

    val alpha: Int

    val red: Int

    val green: Int

    val blue: Int

    val alphaNormalized: Float
        get() = alpha / MAX_VALUE_FLOAT

    val redNormalized: Float
        get() = red / MAX_VALUE_FLOAT

    val greenNormalized: Float
        get() = green / MAX_VALUE_FLOAT

    val blueNormalized: Float
        get() = blue / MAX_VALUE_FLOAT
}
