package com.stumac.financemanager.mapping.converters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

@Component
public class PoundsToPenceConverter extends AbstractConverter<BigDecimal, Integer> {

    @Override
    protected Integer convert(BigDecimal source) {
        return BigDecimal.valueOf(100)
            .multiply(source)
            .setScale(0, ROUND_HALF_UP)
            .intValue();
    }
}
