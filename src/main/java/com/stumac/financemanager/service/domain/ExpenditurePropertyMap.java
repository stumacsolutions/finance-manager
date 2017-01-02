package com.stumac.financemanager.service.domain;

import com.stumac.financemanager.mapping.converters.PoundsToPenceConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExpenditurePropertyMap extends PropertyMap<Expenditure, com.stumac.financemanager.data.domain.Expenditure> {

    private final PoundsToPenceConverter poundsToPenceConverter;

    @Override
    protected void configure() {
        using(poundsToPenceConverter).map(source.getAmount(), destination.getAmount());
    }
}
