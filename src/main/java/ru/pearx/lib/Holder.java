package ru.pearx.lib;

/*
 * Created by mrAppleXZ on 09.11.17 16:20.
 */
public class Holder<T>
{
    private T value;

    public Holder()
    {
    }

    public Holder(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}
