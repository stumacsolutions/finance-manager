package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.mapping.converters.PenceToPoundsConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExpenditureEntityPropertyMap extends PropertyMap<ExpenditureEntity, Expenditure>
{
    private final PenceToPoundsConverter penceToPoundsConverter;

    @Override
    protected void configure()
    {
        using(penceToPoundsConverter).map(source.getAmount(), destination.getAmount());
    }
}
