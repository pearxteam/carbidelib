package ru.pearx.carbide.collections.registry;

/*
 * Created by mrAppleXZ on 25.04.18 10:59.
 */
public class RegistryNameExistsException extends RuntimeException
{
    public RegistryNameExistsException(Object registryName)
    {
        super("The object with a registry name \"" + registryName + "\" has already registered!");
    }
}
