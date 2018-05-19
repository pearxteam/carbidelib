/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.jackson.tests;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;
import org.junit.Test;
import ru.pearx.carbide.DomainedName;
import ru.pearx.carbide.jackson.ModuleCarbide;

import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/*
 * Created by mrAppleXZ on 26.04.18 17:49.
 */
public class DomainedNameTest
{
    static class TestObject
    {
        public String str1;
        public DomainedName nm1;
        public DomainedName nm2;

        public TestObject()
        {
        }

        public TestObject(String str1, DomainedName nm1, DomainedName nm2)
        {
            this.str1 = str1;
            this.nm1 = nm1;
            this.nm2 = nm2;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObject that = (TestObject) o;
            return Objects.equals(str1, that.str1) &&
                    Objects.equals(nm1, that.nm1) &&
                    Objects.equals(nm2, that.nm2);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(str1, nm1, nm2);
        }
    }

    public static ObjectMapper createMapper()
    {
        ObjectMapper map = new ObjectMapper();
        map.registerModule(new ModuleCarbide());
        return map;
    }

    @Test
    public void testSerialization() throws JsonProcessingException
    {
        ObjectMapper map = createMapper();
        assertEquals("\"domain:name\"", map.writeValueAsString(new DomainedName("domain:name")));
        assertEquals("\"domain:name\"", map.writeValueAsString(new DomainedName("domain", "name")));

        assertNotEquals("\"domain:names\"", map.writeValueAsString(new DomainedName("domain:name")));
        assertNotEquals("\"domains:name\"", map.writeValueAsString(new DomainedName("domain", "name")));
    }

    @Test
    public void testComplexSerialization() throws JsonProcessingException
    {
        ObjectMapper map = createMapper();
        assertEquals("{\"str1\":\"hello\",\"nm1\":\"carbide:hey\",\"nm2\":\"notcarbide:bye\"}", map.writeValueAsString(new TestObject("hello", new DomainedName("carbide", "hey"), new DomainedName("notcarbide", "bye"))));
    }

    @Test
    public void testComplexDeserialization() throws IOException
    {
        ObjectMapper map = createMapper();
        assertEquals(new TestObject("hello", new DomainedName("carbide", "hey"), new DomainedName("notcarbide", "bye")), map.readValue("{\"str1\":\"hello\",\"nm1\":\"carbide:hey\",\"nm2\":\"notcarbide:bye\"}", TestObject.class));
        assertNotEquals(new TestObject("test", new DomainedName("abc", "def"), new DomainedName("notcarbide", "bye")), map.readValue("{\"str1\":\"hello\",\"nm1\":\"carbide:hey\",\"nm2\":\"notcarbide:bye\"}", TestObject.class));
    }

    @Test
    public void testDeserialization() throws IOException
    {
        ObjectMapper map = createMapper();
        assertEquals(new DomainedName("domain", "name"), map.readValue("\"domain:name\"", DomainedName.class));
        assertNotEquals(new DomainedName("test", "bee"), map.readValue("\"domain:notaname\"", DomainedName.class));
    }
}
