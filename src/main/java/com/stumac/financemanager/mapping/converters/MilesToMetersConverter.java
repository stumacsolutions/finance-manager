package com.stumac.financemanager.mapping.converters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.stumac.financemanager.mapping.converters.Constants.METERS_IN_A_MILE;
import static java.math.BigDecimal.ROUND_HALF_UP;

@Component
public class MilesToMetersConverter extends AbstractConverter<BigDecimal, Integer> {

    @Override
    protected Integer convert(BigDecimal source) {
        return BigDecimal.valueOf(METERS_IN_A_MILE)
            .multiply(source)
            .setScale(0, ROUND_HALF_UP)
            .intValue();
    }
}
