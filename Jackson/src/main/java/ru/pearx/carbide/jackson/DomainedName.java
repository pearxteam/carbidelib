package ru.pearx.carbide.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;

/*
 * Created by mrAppleXZ on 26.04.18 22:15.
 */
public class DomainedName extends ru.pearx.carbide.DomainedName
{
    public DomainedName()
    {

    }

    @JsonCreator
    public DomainedName(@Nonnull String path)
    {
        super(path);
    }

    public DomainedName(@Nonnull String domain, @Nonnull String name)
    {
        super(domain, name);
    }

    @Override
    @JsonValue
    public String toString()
    {
        return super.toString();
    }
}
