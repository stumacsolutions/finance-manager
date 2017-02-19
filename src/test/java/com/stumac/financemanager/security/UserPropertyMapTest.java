package com.stumac.financemanager.security;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static java.time.LocalDate.now;
import static org.junit.Assert.assertEquals;

public class UserPropertyMapTest
{
    private ModelMapper mapper;

    @Before
    public void setUp()
    {
        mapper = new ModelMapper();
        mapper.addMappings(new UserPropertyMap());
    }

    @Test
    public void shouldMapAllFieldsExceptId()
    {
        User source = User.builder()
            .id(1)
            .avatarUrl("url")
            .name("name")
            .username("username")
            .lastLogin(now())
            .build();
        User target = User.builder().build();

        mapper.map(source, target);

        assertEquals(0, target.getId());
        assertEquals(source.getAvatarUrl(), target.getAvatarUrl());
        assertEquals(source.getName(), target.getName());
        assertEquals(source.getUsername(), target.getUsername());
        assertEquals(source.getLastLogin(), target.getLastLogin());
    }
}
