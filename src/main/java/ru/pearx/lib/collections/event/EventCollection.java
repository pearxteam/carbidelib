package ru.pearx.lib.collections.event;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * Created by mrAppleXZ on 31.01.18 20:08.
 */
public class EventCollection<T> implements Collection<T>
{
    private Collection<T> contained;
    private Runnable event;

    public EventCollection(Collection<T> contained, Runnable event)
    {
        this.contained = contained;
        this.event = event;
    }

    @Override
    public int size()
    {
        return contained.size();
    }

    @Override
    public boolean isEmpty()
    {
        return contained.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return contained.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return contained.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action)
    {
        contained.forEach(action);
    }

    @Override
    public Object[] toArray()
    {
        return contained.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return contained.toArray(a);
    }

    @Override
    public boolean add(T t)
    {
        boolean ret = contained.add(t);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public boolean remove(Object o)
    {
        boolean ret = contained.remove(o);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return contained.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        boolean ret = contained.addAll(c);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean ret = contained.removeAll(c);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter)
    {
        boolean ret = contained.removeIf(filter);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean ret = contained.retainAll(c);
        if(ret)
            event.run();
        return ret;
    }

    @Override
    public void clear()
    {
        contained.clear();
        event.run();
    }
}
