/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the project root.
 */

package ru.pearx.carbide.collections.registry;

import java.util.*;
import java.util.function.Function;

/*
 * Created by mrAppleXZ on 25.04.18 9:37.
 */
public class SimpleRegistry<T, K> implements IRegistry<T, K, T>
{
    private List<T> lst = new ArrayList<>();
    private Collection<T> unmod =  Collections.unmodifiableCollection(lst);
    private Function<T, K> regNameGetter;

    public SimpleRegistry(Function<T, K> regNameGetter)
    {
        this.regNameGetter = regNameGetter;
    }

    public K getRegistryNameOf(T val)
    {
        return regNameGetter.apply(val);
    }

    @Override
    public int size()
    {
        return lst.size();
    }

    @Override
    public T get(K regName)
    {
        for(T t : lst)
        {
            if(getRegistryNameOf(t).equals(regName))
                return t;
        }
        return null;
    }

    @Override
    public Collection<T> getAll()
    {
        return unmod;
    }

    @Override
    public boolean isEmpty()
    {
        return lst.isEmpty();
    }

    @Override
    public boolean isRegistered(K regName)
    {
        for(T t : lst)
        {
            if(getRegistryNameOf(t).equals(regName))
                return true;
        }
        return false;
    }

    @Override
    public boolean isRegisteredAll(Collection<K> regNames)
    {
        for(T t : lst)
        {
            regNames.removeIf(getRegistryNameOf(t)::equals);
        }
        return regNames.isEmpty();
    }

    @Override
    public boolean unregister(K regName)
    {
        for(Iterator<T> it = lst.iterator(); it.hasNext();)
        {
            T next = it.next();
            if(getRegistryNameOf(next).equals(regName))
            {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean unregisterAll(List<K> regNames)
    {
        boolean flag = false;
        for(Iterator<T> it = lst.iterator(); it.hasNext();)
        {
            T next = it.next();
            for(Iterator<K> itNames = regNames.iterator(); itNames.hasNext();)
            {
                K name = itNames.next();
                if(getRegistryNameOf(next).equals(name))
                {
                    flag = true;
                    it.remove();
                    itNames.remove();
                }
            }
        }
        return flag;
    }

    @Override
    public boolean register(T t)
    {
        K regName = getRegistryNameOf(t);
        if(isRegistered(regName))
            throw new RegistryNameExistsException(regName);
        return lst.add(t);
    }

    @Override
    public boolean registerAll(List<T> toRegs)
    {
        boolean flag = false;
        for (T toReg : toRegs)
        {
            K toRegName = getRegistryNameOf(toReg);
            for (T t : lst)
            {
                if (getRegistryNameOf(t).equals(toRegName))
                    throw new RegistryNameExistsException(toRegName);
            }
            flag |= lst.add(toReg);
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator()
    {
        return lst.iterator();
    }
}
