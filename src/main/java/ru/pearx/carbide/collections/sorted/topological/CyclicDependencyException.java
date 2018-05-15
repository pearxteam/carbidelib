package ru.pearx.carbide.collections.sorted.topological;

/*
 * Created by mrAppleXZ on 15.05.18 11:36.
 */
public class CyclicDependencyException extends RuntimeException
{
    public CyclicDependencyException(TopologicalSorting.Node o)
    {
        super("A cyclic dependency has been found! A node \"" + o + "\" has been already visited!");
    }
}
