package ru.pearx.carbide.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.pearx.carbide.DomainedName;

import java.io.IOException;

/*
 * Created by mrAppleXZ on 27.04.18 16:36.
 */
public class DomainedNameSerializer extends StdSerializer<DomainedName>
{
    protected DomainedNameSerializer(Class<DomainedName> t)
    {
        super(t);
    }

    protected DomainedNameSerializer(JavaType type)
    {
        super(type);
    }

    protected DomainedNameSerializer(Class<?> t, boolean dummy)
    {
        super(t, dummy);
    }

    protected DomainedNameSerializer(StdSerializer<?> src)
    {
        super(src);
    }

    @Override
    public void serialize(DomainedName value, JsonGenerator gen, SerializerProvider provider) throws IOException
    {
        gen.writeString(value.getDomain() + ":" + value.getName());
    }
}
