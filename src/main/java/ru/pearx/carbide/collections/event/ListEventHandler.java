/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.collections.event;

import ru.pearx.carbide.Tuple;

import java.util.Collection;

/*
 * Created by mrAppleXZ on 03.02.18 18:18.
 */
public interface ListEventHandler<T>
{
    void onAdd(T t);
    void onAdd(Collection<? extends T> t);
    void onRemove(T o, int index);
    void onRemove(Collection<Tuple<T, Integer>> col);
    void onPut(int index, T t);
    void onPut(int index, Collection<? extends T> t);
    void onClear(Collection<T> col);
    void onSet(int index, T prevValue, T newValue);
}
