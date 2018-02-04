import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.pearx.lib.Holder;
import ru.pearx.lib.PXL;
import ru.pearx.lib.Tuple;
import ru.pearx.lib.collections.event.EventList;
import ru.pearx.lib.collections.event.ListEventHandler;

import java.util.*;

/*
 * Created by mrAppleXZ on 04.02.18 13:31.
 */
public class EventCollectionTest
{
    public static final String[] STARTING_ARRAY = new String[] {"Torvalds", "stone", "Stallman", "pickle", "grid", "stone", "soil"};
    public static final List<String> STARTING_LIST = Arrays.asList(STARTING_ARRAY);
    public static class TestingContext
    {
        public List<String> lastAdded = new ArrayList<>();
        public List<Tuple<String, Integer>> lastRemoved = new ArrayList<>();
        public Holder<Integer> lastPutIndex = new Holder<>(-1);
        public List<String> lastPut = new ArrayList<>();
        public Holder<Boolean> cleared = new Holder<>(false);
        public Holder<Integer> lastSetIndex = new Holder<>(-1);
        public Holder<String> lastSetNew = new Holder<>(null);
        public Holder<String> lastSetPrev = new Holder<>(null);

        public EventList<String> ev = new EventList<>(new ArrayList<>(STARTING_LIST), new ListEventHandler<String>()
        {
            @Override
            public void onAdd(String s)
            {
                onAdd(Collections.singleton(s));
            }

            @Override
            public void onAdd(Collection<? extends String> t)
            {
                lastAdded.clear();
                lastAdded.addAll(t);
            }

            @Override
            public void onRemove(String o, int index)
            {
                onRemove(Collections.singleton(new Tuple<>(o, index)));
            }

            @Override
            public void onRemove(Collection<Tuple<String, Integer>> col)
            {
                lastRemoved.clear();
                lastRemoved.addAll(col);
            }

            @Override
            public void onPut(int index, String s)
            {
                onPut(index, Collections.singleton(s));
            }

            @Override
            public void onPut(int index, Collection<? extends String> t)
            {
                lastPutIndex.setValue(index);
                lastPut.clear();
                lastPut.addAll(t);
            }

            @Override
            public void onClear()
            {
                cleared.setValue(true);
            }

            @Override
            public void onSet(int index, String prevValue, String newValue)
            {
                lastSetIndex.setValue(index);
                lastSetPrev.setValue(prevValue);
                lastSetNew.setValue(newValue);
            }
        });
    }

    @Test
    public void testAdd()
    {
        TestingContext context = new TestingContext();

        context.ev.add("pickle");
        assertEquals(Collections.singletonList("pickle"), context.lastAdded);
        context.ev.add("stone");
        assertEquals(Collections.singletonList("stone"), context.lastAdded);

        assertEquals(Arrays.asList("Torvalds", "stone", "Stallman", "pickle", "grid", "stone", "soil", "pickle", "stone"), context.ev);
    }

    @Test
    public void testAddAll()
    {
        TestingContext context = new TestingContext();

        context.ev.addAll(Arrays.asList("rectangle", "triangle", "gem"));
        assertEquals(Arrays.asList("rectangle", "triangle", "gem"), context.lastAdded);

        assertEquals(Arrays.asList("Torvalds", "stone", "Stallman", "pickle", "grid", "stone", "soil", "rectangle", "triangle", "gem"), context.ev);
    }

    @Test
    public void testMiscNotChanging()
    {
        TestingContext context = new TestingContext();

        assertEquals(7, context.ev.size());
        assertFalse(context.ev.isEmpty());
        assertTrue(context.ev.contains("pickle"));
        assertFalse(context.ev.contains("abracadabra"));
        assertTrue(context.ev.containsAll(Arrays.asList("Torvalds", "soil", "grid")));
        assertFalse(context.ev.containsAll(Arrays.asList("Torvalds", "soil", "butter")));
        assertEquals(1, context.ev.indexOf("stone"));
        assertArrayEquals(STARTING_ARRAY, context.ev.toArray());
        assertArrayEquals(STARTING_ARRAY, context.ev.toArray(new String[]{}));
        assertEquals(5, context.ev.lastIndexOf("stone"));
        assertEquals("pickle", context.ev.get(3));
        assertEquals(Arrays.asList("pickle", "grid"), context.ev.subList(3, 5));

        int i = 0;
        for(String s : context.ev)
        {
            assertEquals(s, context.ev.get(i));
            i++;
        }

        assertTrue(context.ev.equals(new TestingContext().ev));
        assertEquals(PXL.joinArray(", ", "[", "]", STARTING_ARRAY), context.ev.toString());
    }

    @Test
    public void testRemoveAtIndex()
    {
        TestingContext context = new TestingContext();

        assertEquals("Stallman", context.ev.remove(2));
        assertEquals(Collections.singletonList(new Tuple<>("Stallman", 2)), context.lastRemoved);

        assertEquals(Arrays.asList("Torvalds", "stone", "pickle", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testRemove()
    {
        TestingContext context = new TestingContext();

        assertTrue(context.ev.remove("stone"));
        assertEquals(Collections.singletonList(new Tuple<>("stone", 1)), context.lastRemoved);

        assertEquals(Arrays.asList("Torvalds", "Stallman", "pickle", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testRemoveAll()
    {
        TestingContext context = new TestingContext();

        assertTrue(context.ev.removeAll(Arrays.asList("Stallman", "pickle", "tuple")));
        assertEquals(Arrays.asList(new Tuple<>("Stallman", 2), new Tuple<>("pickle", 3)), context.lastRemoved);

        assertEquals(Arrays.asList("Torvalds", "stone", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testRetainAll()
    {
        TestingContext context = new TestingContext();

        assertTrue(context.ev.retainAll(Arrays.asList("pickle", "soil", "grid", "stone")));
        assertEquals(Arrays.asList(new Tuple<>("Torvalds", 0), new Tuple<>("Stallman", 2)), context.lastRemoved);

        assertEquals(Arrays.asList("stone", "pickle", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testFalseRemovals()
    {
        TestingContext context = new TestingContext();
        //remove and check events
        assertFalse(context.ev.remove("ball"));
        assertTrue(context.lastRemoved.isEmpty());

        //removeAll and check events
        assertFalse(context.ev.removeAll(Arrays.asList("woosh", "bush")));
        assertTrue(context.lastRemoved.isEmpty());

        //retainAll and check events
        assertFalse(context.ev.retainAll(STARTING_LIST));
        assertTrue(context.lastRemoved.isEmpty());

        //check contents
        assertEquals(STARTING_LIST, context.ev);
    }

    @Test
    public void testPut()
    {
        TestingContext context = new TestingContext();

        context.ev.add(0, "plastic");
        assertEquals(0, (int)context.lastPutIndex.getValue());
        assertEquals(Collections.singletonList("plastic"), context.lastPut);

        assertEquals(Arrays.asList("plastic", "Torvalds", "stone", "Stallman", "pickle", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testPutAll()
    {
        TestingContext context = new TestingContext();

        context.ev.addAll(1, Arrays.asList("Torvalds", "grid"));
        assertEquals(1, (int)context.lastPutIndex.getValue());
        assertEquals(Arrays.asList("Torvalds", "grid"), context.lastPut);

        assertEquals(Arrays.asList("Torvalds", "Torvalds", "grid", "stone", "Stallman", "pickle", "grid", "stone", "soil"), context.ev);
    }

    @Test
    public void testClear()
    {
        TestingContext context = new TestingContext();

        context.ev.clear();
        assertTrue(context.cleared.getValue());

        assertEquals(Collections.emptyList(), context.ev);
    }

    @Test
    public void testSet()
    {
        TestingContext context = new TestingContext();

        context.ev.set(3, "bikini");
        assertEquals(3, (int)context.lastSetIndex.getValue());
        assertEquals("bikini", context.lastSetNew.getValue());
        assertEquals("pickle", context.lastSetPrev.getValue());

        assertEquals(Arrays.asList("Torvalds", "stone", "Stallman", "bikini", "grid", "stone", "soil"), context.ev);
    }
}
