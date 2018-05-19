/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

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
