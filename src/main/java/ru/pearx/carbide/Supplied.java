/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide;

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

    public void supply()
    {
        cached = getter.get();
    }
}
