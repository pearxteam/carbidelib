package ru.pearx.carbidelib


/*
 * Created by mrAppleXZ on 23.08.18.
 */
fun requireRange(min: Int, maxInclusive: Int, element: String, actual: Int)
{
    if(actual < min || actual > maxInclusive)
        throw IllegalArgumentException("The value of $element should be in range $min..$maxInclusive, but was $actual.")
}