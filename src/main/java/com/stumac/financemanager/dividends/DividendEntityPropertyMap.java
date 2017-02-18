package com.stumac.financemanager.dividends;

import com.stumac.financemanager.mapping.converters.PenceToPoundsConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DividendEntityPropertyMap extends PropertyMap<DividendEntity, Dividend>
{
    private final PenceToPoundsConverter penceToPoundsConverter;

    @Override
    protected void configure()
    {
        using(penceToPoundsConverter).map(source.getAmount(), destination.getAmount());
    }
}
