/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.collections.event;

import ru.pearx.carbide.Tuple;

import java.util.*;

/*
 * Created by mrAppleXZ on 27.09.17 17:23.
 */
public class EventList<T> implements List<T>
{
    private List<T> list;
    private ListEventHandler<T> handler;

    public EventList(List<T> baseList, ListEventHandler<T> handler)
    {
        this.list = baseList;
        this.handler = handler;
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
            handler.onAdd(t);
        return ret;
    }

    @Override
    public boolean remove(Object o)
    {
        int index = list.indexOf(o);
        if(index < 0)
            return false;

        T t = list.get(index);
        list.remove(index);
        handler.onRemove(t, index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return list.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection)
    {
        boolean flag = false;
        List<T> lst = new ArrayList<>();
        for(T t : collection)
        {
            boolean b = list.add(t);
            if(b)
            {
                flag = true;
                lst.add(t);
            }
        }
        if(flag)
            handler.onAdd(lst);
        return flag;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection)
    {
        boolean ret = list.addAll(i, collection);
        if(ret)
            handler.onPut(i, collection);
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> collection)
    {
        return rmAll(collection, false);
    }

    @Override
    public boolean retainAll(Collection<?> collection)
    {
        return rmAll(collection, true);
    }

    private boolean rmAll(Collection<?> collection, boolean invert)
    {
        List<Tuple<T, Integer>> toRemove = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            T val = list.get(i);
            if(collection.contains(val) == !invert)
            {
                toRemove.add(new Tuple<>(val, i));
            }
        }
        for(int i = 0; i < toRemove.size(); i++)
        {
            list.remove(toRemove.get(i).getRight() - i);
        }
        handler.onRemove(toRemove);
        return !toRemove.isEmpty();
    }


    @Override
    public void clear()
    {
        List<T> lst = new ArrayList<>(this);
        list.clear();
        handler.onClear(lst);
    }

    @Override
    public T get(int i)
    {
        return list.get(i);
    }

    @Override
    public T set(int i, T t)
    {
        T prev = list.set(i, t);
        handler.onSet(i, prev, t);
        return prev;
    }

    @Override
    public void add(int i, T t)
    {
        list.add(i, t);
        handler.onPut(i, t);
    }

    @Override
    public T remove(int i)
    {
        T t = list.remove(i);
        handler.onRemove(t, i);
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
    public List<T> subList(int fromIndex, int toIndex)
    {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object obj)
    {
        return list.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return list.hashCode();
    }

    @Override
    public String toString()
    {
        return list.toString();
    }
}
