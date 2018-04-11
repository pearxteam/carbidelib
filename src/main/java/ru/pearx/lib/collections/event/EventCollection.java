package ru.pearx.lib.collections.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * Created by mrAppleXZ on 05.02.18 18:24.
 */
public class EventCollection<T> implements Collection<T>
{
    private Collection<T> col;
    private CollectionEventHandler<T> handler;

    public EventCollection(Collection<T> col, CollectionEventHandler<T> handler)
    {
        this.col = col;
        this.handler = handler;
    }

    @Override
    public int size()
    {
        return col.size();
    }

    @Override
    public boolean isEmpty()
    {
        return col.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return col.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return col.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return col.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return col.toArray(a);
    }

    @Override
    public boolean add(T t)
    {
        boolean ret = col.add(t);
        if(ret)
            handler.onAdd(t);
        return ret;
    }

    @Override
    public boolean remove(Object o)
    {
        boolean ret = col.remove(o);
        if(ret)
            handler.onRemove(o);
        return ret;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return col.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        boolean ret = col.addAll(c);
        if(ret)
            col.addAll(c);
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean ret = col.removeAll(c);
        if(ret)
            handler.onRemove(c);
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean ret = false;
        for(Object o : c)
        {
            if(!contains(o))
                if(remove(o))
                    ret = true;
        }
        return ret;
    }

    @Override
    public void clear()
    {
        List<T> lst = new ArrayList<>(this);
        col.clear();
        handler.onClear(lst);
    }

    @Override
    public int hashCode()
    {
        return col.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return col.equals(obj);
    }

    @Override
    public String toString()
    {
        return col.toString();
    }
}
