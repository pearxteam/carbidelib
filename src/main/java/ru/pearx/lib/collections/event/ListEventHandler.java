package ru.pearx.lib.collections.event;

import com.sun.istack.internal.Nullable;
import ru.pearx.lib.Tuple;

import java.util.Collection;
import java.util.List;

/*
 * Created by mrAppleXZ on 03.02.18 18:18.
 */
public interface ListEventHandler<T>
{
    void onAdd(T t);
    void onAdd(Collection<? extends T> t);
    void onRemove(Object o, int index);
    void onRemove(Collection<Tuple<T, Integer>> col);
    void onPut(int index, T t);
    void onPut(int index, Collection<? extends T> t);
    void onClear();
    void onSet(int index, T prevValue, T newValue);
}
