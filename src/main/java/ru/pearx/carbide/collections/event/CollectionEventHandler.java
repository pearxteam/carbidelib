/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.collections.event;

import java.util.Collection;

/*
 * Created by mrAppleXZ on 05.02.18 18:25.
 */
public interface CollectionEventHandler<T>
{
    void onAdd(T t);
    void onAdd(Collection<? extends T> t);
    void onRemove(Object o);
    void onRemove(Collection<Object> col);
    void onClear(Collection<T> t);
}
