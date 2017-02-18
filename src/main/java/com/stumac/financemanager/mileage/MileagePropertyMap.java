package com.stumac.financemanager.mileage;

import com.stumac.financemanager.mapping.converters.MilesToMetersConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MileagePropertyMap extends PropertyMap<Mileage, MileageEntity>
{
    private final MilesToMetersConverter milesToMetersConverter;

    @Override
    protected void configure()
    {
        using(milesToMetersConverter).map(source.getDistance(), destination.getDistance());
    }
}
