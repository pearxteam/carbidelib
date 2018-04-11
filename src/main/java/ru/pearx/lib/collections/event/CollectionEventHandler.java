package ru.pearx.lib.collections.event;

import ru.pearx.lib.Tuple;

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
