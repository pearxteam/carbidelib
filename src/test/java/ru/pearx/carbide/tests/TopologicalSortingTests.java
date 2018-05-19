/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import ru.pearx.carbide.collections.sorted.topological.TopologicalSorting;

import java.util.Arrays;
import java.util.List;

/*
 * Created by mrAppleXZ on 15.05.18 10:50.
 */
public class TopologicalSortingTests
{
    @Test
    public void testSorting()
    {
        List<String> sorted = new TopologicalSorting.Builder<String>().setRoot("modApi")
                .addConnection("modApi", "simpleTrash")
                .addConnection("modApi", "advancedTrash")
                .addConnection("simpleTrashAddon", "compatTrash").addConnection("advancedTrash", "compatTrash")
                .addConnection("leatherCore", "twoCoresMod").addConnection("scriptCore", "twoCoresMod")
                .addConnection("modApi", "leatherCore")
                .addConnection("modApi", "scriptCore")
                .addConnection("simpleTrash", "simpleTrashAddon").build();
        assertEquals(Arrays.asList("modApi", "simpleTrash", "simpleTrashAddon", "advancedTrash", "compatTrash", "leatherCore", "scriptCore", "twoCoresMod"), sorted);
    }
}
