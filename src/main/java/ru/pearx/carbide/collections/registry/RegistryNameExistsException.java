/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

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
