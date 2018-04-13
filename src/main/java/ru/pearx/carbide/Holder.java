/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

/*
 * Created by mrAppleXZ on 09.11.17 16:20.
 */

/**
 * A holder for the object.
 * @param <T> Type of the held object.
 */
public class Holder<T>
{
    /**
     * Held object.
     */
    private T value;

    /**
     * Initializes a new {@link Holder} with a null held object.
     */
    public Holder()
    {
    }

    /**
     * Initializes a new {@link Holder} with a specified held object.
     */
    public Holder(T value)
    {
        this.value = value;
    }

    /**
     * Gets the held object.
     */
    public T getValue()
    {
        return value;
    }

    /**
     * Sets the held object.
     */
    public void setValue(T value)
    {
        this.value = value;
    }
}
