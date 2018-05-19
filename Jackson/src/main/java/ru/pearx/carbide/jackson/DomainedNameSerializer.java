/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

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
