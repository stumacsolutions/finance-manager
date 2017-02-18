package com.stumac.financemanager.security;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
class UserPropertyMap extends PropertyMap<User, User>
{
    @Override
    protected void configure()
    {
        skip().setId(0);
    }
}
