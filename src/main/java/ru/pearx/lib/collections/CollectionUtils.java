package ru.pearx.lib.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by mrAppleXZ on 16.11.17 18:42.
 */
public final class CollectionUtils
{
    private static final String EXCEPTION_TEXT = "Element with index %d isn't a valid %s! (given: %s, expected: %s!";

    /**
     * Creates a HashMap with key of class keyClass and value of class valClass filled with the entries.
     * @param keyClass Key class.
     * @param valClass Value class.
     * @param entries The entries that the map should be filled with. For instance, ["str1", 12, "str2", 6, "str3", 633].
     * @param <K> Key.
     * @param <V> Value.
     */
    public static <K, V> Map<K, V> createMap(Class<K> keyClass, Class<V> valClass, Object... entries)
    {
        Map<K, V> map = new HashMap<>();
        for(int i = 0; i < entries.length; i += 2)
        {
            Object ko = entries[i];
            Object vo = entries[i + 1];
            if(!ko.getClass().equals(keyClass))
                throw new IllegalArgumentException(String.format(EXCEPTION_TEXT, i, "key", ko.getClass(), keyClass));
            if(!vo.getClass().equals(valClass))
                throw new IllegalArgumentException(String.format(EXCEPTION_TEXT, i + 1, "value", vo.getClass(), valClass));
            map.put((K)ko, (V)vo);
        }
        return map;
    }

    /**
     * Checks whether the map of lists is empty (every list in the map is empty).
     * @param map A map.
     * @param <K> Key type.
     * @param <V> Value type.
     * @return True if the map of lists is empty, otherwise - false.
     */
    public static <K, V> boolean isMapOfListsEmpty(Map<K, List<V>> map)
    {
        for(Map.Entry<K, List<V>> entr : map.entrySet())
        {
            if(!entr.getValue().isEmpty())
                return false;
        }
        return true;
    }
}
