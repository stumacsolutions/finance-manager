package com.stumac.financemanager.service.income;

import com.stumac.financemanager.data.income.IncomeEntity;
import com.stumac.financemanager.mapping.converters.PenceToPoundsConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class IncomeEntityPropertyMap extends PropertyMap<IncomeEntity, Income> {

    private final PenceToPoundsConverter penceToPoundsConverter;

    @Override
    protected void configure() {
        using(penceToPoundsConverter).map(source.getAmount(), destination.getAmount());
    }
}
