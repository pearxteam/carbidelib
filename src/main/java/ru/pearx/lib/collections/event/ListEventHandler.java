package ru.pearx.lib.collections.event;

import ru.pearx.lib.Tuple;

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
