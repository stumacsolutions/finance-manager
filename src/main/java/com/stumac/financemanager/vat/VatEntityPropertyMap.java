package com.stumac.financemanager.vat;

import com.stumac.financemanager.mapping.converters.PenceToPoundsConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VatEntityPropertyMap extends PropertyMap<VatEntity, Vat>
{
    private final PenceToPoundsConverter penceToPoundsConverter;

    @Override
    protected void configure()
    {
        using(penceToPoundsConverter).map(source.getAmount(), destination.getAmount());
    }
}
