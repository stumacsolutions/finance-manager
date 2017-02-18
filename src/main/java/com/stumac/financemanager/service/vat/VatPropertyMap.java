package com.stumac.financemanager.service.vat;

import com.stumac.financemanager.data.vat.VatEntity;
import com.stumac.financemanager.mapping.converters.PoundsToPenceConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VatPropertyMap extends PropertyMap<Vat, VatEntity>
{

    private final PoundsToPenceConverter poundsToPenceConverter;

    @Override
    protected void configure()
    {
        using(poundsToPenceConverter).map(source.getAmount(), destination.getAmount());
    }
}
