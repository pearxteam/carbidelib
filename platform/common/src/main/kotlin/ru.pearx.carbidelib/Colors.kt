package ru.pearx.carbidelib


/*
 * Created by mrAppleXZ on 23.08.18.
 */
const val COLOR_SHIFT_ALPHA = 24
const val COLOR_SHIFT_RED = 16
const val COLOR_SHIFT_GREEN = 8
const val COLOR_SHIFT_BLUE = 0
const val COLOR_MASK = 0xFF
const val COLOR_MIN = 0
const val COLOR_MAX = 255

interface Color
{
    val argb: Int

    val alpha: Int
    val red: Int
    val green: Int
    val blue: Int

    val redCoefficient: Float
        get() = red / 255F
    val greenCoefficient: Float
        get() = green / 255F
    val blueCoefficient: Float
        get() = blue / 255F
    val alphaCoefficient: Float
        get() = alpha / 255F
}

interface MutableColor : Color
{
    override var argb: Int

    override var alpha: Int
    override var red: Int
    override var green: Int
    override var blue: Int
}


class ArgbColor(override var argb: Int) : MutableColor
{
    override var alpha: Int
        get() = getFromArgb(COLOR_SHIFT_ALPHA)
        set(value) { modifyArgb(COLOR_SHIFT_ALPHA, "alpha", value) }

    override var red: Int
        get() = getFromArgb(COLOR_SHIFT_RED)
        set(value) { modifyArgb(COLOR_SHIFT_RED, "red", value) }

    override var green: Int
        get() = getFromArgb(COLOR_SHIFT_GREEN)
        set(value) { modifyArgb(COLOR_SHIFT_GREEN, "green", value) }

    override var blue: Int
        get() = getFromArgb(COLOR_SHIFT_BLUE)
        set(value) { modifyArgb(COLOR_SHIFT_BLUE, "blue", value) }

    private fun getFromArgb(shift: Int) = argb ushr shift and COLOR_MASK

    private fun modifyArgb(shift: Int, name: String, value: Int)
    {
        requireRange(COLOR_MIN, COLOR_MAX, name, value)
        argb = (argb and (COLOR_MASK shl shift).inv()) or (value shl shift)
    }

    override fun toString(): String
    {
        return "#${argb.toString(16).padStart(8)}"
    }
}

fun colorOfArgb(argb: Int): MutableColor = ArgbColor(argb)

fun colorOfRgb(rgb: Int): MutableColor = ArgbColor(rgb or (COLOR_MASK shl COLOR_SHIFT_ALPHA))

fun colorOf(red: Int, green: Int, blue: Int, alpha: Int = COLOR_MAX): MutableColor
{
    val col = ArgbColor(0)
    col.red = red
    col.green = green
    col.blue = blue
    col.alpha = alpha
    return col
}