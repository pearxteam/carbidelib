/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

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
