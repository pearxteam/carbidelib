/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.collections.event;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Created by mrAppleXZ on 16.10.17 20:38.
 */
public class EventMap<K, V> implements Map<K, V>
{
    private Runnable onModify;
    private Map<K, V> baseMap;

    public EventMap(Map<K, V> baseMap)
    {
        this.baseMap = baseMap;
    }

    public EventMap(Map<K, V> baseMap, Runnable onModify)
    {
        this.onModify = onModify;
        this.baseMap = baseMap;
    }

    public void onModify()
    {
        if(onModify != null)
            onModify.run();
    }

    @Override
    public int size()
    {
        return baseMap.size();
    }

    @Override
    public boolean isEmpty()
    {
        return baseMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return baseMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return baseMap.containsValue(value);
    }

    @Override
    public V get(Object key)
    {
        return baseMap.get(key);
    }

    @Override
    public V put(K key, V value)
    {
        V val = baseMap.put(key, value);
        onModify();
        return val;
    }

    @Override
    public V remove(Object key)
    {
        V val = baseMap.remove(key);
        onModify();
        return val;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        baseMap.putAll(m);
        onModify();
    }

    @Override
    public void clear()
    {
        baseMap.clear();
        onModify();
    }

    @Override
    public Set<K> keySet()
    {
        return baseMap.keySet();
    }

    @Override
    public Collection<V> values()
    {
        return baseMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        return baseMap.entrySet();
    }
}
