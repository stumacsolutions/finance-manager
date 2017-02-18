package com.stumac.financemanager.service.mileage;

import com.stumac.financemanager.data.mileage.MileageEntity;
import com.stumac.financemanager.mapping.converters.MetersToMilesConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MileageEntityPropertyMap extends PropertyMap<MileageEntity, Mileage>
{

    private final MetersToMilesConverter metersToMilesConverter;

    @Override
    protected void configure()
    {
        using(metersToMilesConverter).map(source.getDistance(), destination.getDistance());
    }
}
