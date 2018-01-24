package ru.pearx.lib;

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
