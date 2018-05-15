package ru.pearx.carbide.collections.sorted.topological;

/*
 * Created by mrAppleXZ on 14.05.18 20:31.
 */
public class NodeNotFoundException extends RuntimeException
{
    public NodeNotFoundException(Object o)
    {
        super("Couldn't find a node with value \"" + o + "\"!");
    }
}
