package ru.pearx.lib;

import java.util.function.Supplier;

/*
 * Created by mrAppleXZ on 13.12.17 19:10.
 */
public class Supplied<T>
{
    private T cached;
    private Supplier<T> getter;

    public Supplied(Supplier<T> getter)
    {
        this.getter = getter;
    }

    public T get()
    {
        if(cached == null)
            cached = getter.get();
        return cached;
    }
}
