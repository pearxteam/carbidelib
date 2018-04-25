/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.collections.registry;

/*
 * Created by mrAppleXZ on 24.04.18 17:52.
 */

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface IRegistry<T, K, PAIR> extends Iterable<PAIR>
{
    int size();
    T get(K regName);
    Collection<PAIR> getAll();
    boolean isEmpty();
    boolean isRegistered(K regName);
    boolean isRegisteredAll(Collection<K> regNames);

    boolean unregister(K regName);
    boolean unregisterAll(List<K> regNames);

    boolean register(PAIR pair);
    boolean registerAll(List<PAIR> pairs);

    @Override
    default Spliterator<PAIR> spliterator()
    {
        return Spliterators.spliterator(iterator(), size(), 0);
    }

    default Stream<PAIR> stream()
    {
        return StreamSupport.stream(spliterator(), false);
    }

    default Stream<PAIR> parallelStream()
    {
        return StreamSupport.stream(spliterator(), true);
    }
}
