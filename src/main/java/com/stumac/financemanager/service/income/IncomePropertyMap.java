package com.stumac.financemanager.service.income;

import com.stumac.financemanager.data.income.IncomeEntity;
import com.stumac.financemanager.mapping.converters.PoundsToPenceConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class IncomePropertyMap extends PropertyMap<Income, IncomeEntity>
{
    private final PoundsToPenceConverter poundsToPenceConverter;

    @Override
    protected void configure()
    {
        using(poundsToPenceConverter).map(source.getAmount(), destination.getAmount());
    }
}
