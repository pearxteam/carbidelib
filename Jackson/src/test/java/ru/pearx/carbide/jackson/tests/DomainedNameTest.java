package ru.pearx.carbide.jackson.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import ru.pearx.carbide.jackson.DomainedName;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/*
 * Created by mrAppleXZ on 26.04.18 17:49.
 */
public class DomainedNameTest
{
    @Test
    public void testSerialization() throws JsonProcessingException
    {
        ObjectMapper map = new ObjectMapper();
        assertEquals("\"domain:name\"", map.writeValueAsString(new DomainedName("domain:name")));
        assertEquals("\"domain:name\"", map.writeValueAsString(new DomainedName("domain", "name")));

        assertNotEquals("\"domain:names\"", map.writeValueAsString(new DomainedName("domain:name")));
        assertNotEquals("\"domains:name\"", map.writeValueAsString(new DomainedName("domain", "name")));
    }

    @Test
    public void testDeserialization() throws IOException
    {
        ObjectMapper map = new ObjectMapper();
        assertEquals(new DomainedName("domain", "name"), map.readValue("\"domain:name\"", DomainedName.class));
        assertNotEquals(new DomainedName("test", "bee"), map.readValue("\"domain:notaname\"", DomainedName.class));
    }
}
