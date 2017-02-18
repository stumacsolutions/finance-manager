package com.stumac.financemanager.mapping.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
class MappingConfig
{
    @Bean
    ModelMapper modelMapper(Collection<PropertyMap<?, ?>> propertyMaps)
    {
        ModelMapper mapper = new ModelMapper();
        propertyMaps.forEach(mapper::addMappings);
        return mapper;
    }
}
