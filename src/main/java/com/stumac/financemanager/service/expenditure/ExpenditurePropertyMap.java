package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.mapping.converters.PoundsToPenceConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExpenditurePropertyMap extends PropertyMap<Expenditure, ExpenditureEntity>
{
    private final PoundsToPenceConverter poundsToPenceConverter;

    @Override
    protected void configure()
    {
        using(poundsToPenceConverter).map(source.getAmount(), destination.getAmount());
    }
}
