package com.stumac.financemanager.service.dividend;

import com.stumac.financemanager.data.dividend.DividendEntity;
import com.stumac.financemanager.mapping.converters.PoundsToPenceConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DividendPropertyMap extends PropertyMap<Dividend, DividendEntity>
{

    private final PoundsToPenceConverter poundsToPenceConverter;

    @Override
    protected void configure()
    {
        using(poundsToPenceConverter).map(source.getAmount(), destination.getAmount());
    }
}
