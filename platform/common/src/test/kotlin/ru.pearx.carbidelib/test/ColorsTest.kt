package ru.pearx.carbidelib.test

import ru.pearx.carbidelib.colorOf
import ru.pearx.carbidelib.colorOfArgb
import ru.pearx.carbidelib.colorOfRgb
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


/*
 * Created by mrAppleXZ on 23.08.18.
 */
class ColorsTest
{
    @Test
    fun testSingleArgbCreation()
    {
        assertEquals(0x06FFFFFF, colorOfArgb(0x6FFFFFF).argb)
        assertEquals(0xF, colorOfArgb(15).argb)
    }

    @Test
    fun testSingleRgbCreation()
    {
        assertEquals(0xFF181920.toInt(), colorOfRgb(0x181920).argb)
    }

    @Test
    fun testPartArgbCreation()
    {
        assertEquals(0xFE5600FF.toInt(), colorOf(red = 86, green = 0, blue = 255, alpha = 254).argb)
    }

    @Test
    fun testUnderflowCreation()
    {
        assertFailsWith<IllegalArgumentException> { colorOf(-1, 0, 0) }
    }

    @Test
    fun testOverflowCreation()
    {
        assertFailsWith<IllegalArgumentException> { colorOf(256, 0, 0) }
    }

    @Test
    fun testColorExtraction()
    {
        val col = colorOfArgb(0xFF780012.toInt())
        assertEquals(255, col.alpha)
        assertEquals(120, col.red)
        assertEquals(0, col.green)
        assertEquals(18, col.blue)
    }

    @Test
    fun testCoefficients()
    {
        //todo
    }
}