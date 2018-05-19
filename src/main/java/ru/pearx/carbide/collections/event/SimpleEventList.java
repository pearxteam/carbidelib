/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.collections.event;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Created by mrAppleXZ on 03.02.18 22:18.
 */
public class SimpleEventList<T> implements List<T>
{
    private List<T> list;
    private Runnable onModify;

    public SimpleEventList(List<T> baseList, Runnable onModify)
    {
        this.list = baseList;
        this.onModify = onModify;
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return list.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s)
    {
        return list.toArray(t1s);
    }

    @Override
    public boolean add(T t)
    {
        boolean ret = list.add(t);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public boolean remove(Object o)
    {
        boolean ret = list.remove(o);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return list.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection)
    {
        boolean ret = list.addAll(collection);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection)
    {
        boolean ret = list.addAll(i, collection);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> collection)
    {
        boolean ret = list.removeAll(collection);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> collection)
    {
        boolean ret = list.retainAll(collection);
        if(ret)
            onModify.run();
        return ret;
    }

    @Override
    public void clear()
    {
        list.clear();
        onModify.run();
    }

    @Override
    public T get(int i)
    {
        return list.get(i);
    }

    @Override
    public T set(int i, T t)
    {
        T val = list.set(i, t);
        onModify.run();
        return val;
    }

    @Override
    public void add(int i, T t)
    {
        list.add(i, t);
        onModify.run();
    }

    @Override
    public T remove(int i)
    {
        T t = list.remove(i);
        onModify.run();
        return t;
    }

    @Override
    public int indexOf(Object o)
    {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i)
    {
        return list.listIterator(i);
    }

    @Override
    public List<T> subList(int i, int i1)
    {
        return list.subList(i, i1);
    }
}
