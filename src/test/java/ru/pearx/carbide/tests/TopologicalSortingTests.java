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
        List<String> sorted = new TopologicalSorting.Builder<String>().setRoot("modApi").addObject("modApi")
                .addObject("simpleTrash").addConnection("modApi", "simpleTrash")
                .addObject("advancedTrash").addConnection("modApi", "advancedTrash")
                .addObject("compatTrash").addConnection("simpleTrashAddon", "compatTrash").addConnection("advancedTrash", "compatTrash")
                .addObject("twoCoresMod").addConnection("leatherCore", "twoCoresMod").addConnection("scriptCore", "twoCoresMod")
                .addObject("leatherCore").addConnection("modApi", "leatherCore")
                .addObject("scriptCore").addConnection("modApi", "scriptCore")
                .addObject("simpleTrashAddon").addConnection("simpleTrash", "simpleTrashAddon").build();
        assertEquals(Arrays.asList("modApi", "simpleTrash", "simpleTrashAddon", "advancedTrash", "compatTrash", "leatherCore", "scriptCore", "twoCoresMod"), sorted);
    }
}
