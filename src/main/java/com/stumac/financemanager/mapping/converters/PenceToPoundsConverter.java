package com.stumac.financemanager.mapping.converters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PenceToPoundsConverter extends AbstractConverter<Integer, BigDecimal>
{

    @Override
    protected BigDecimal convert(Integer source)
    {
        return new BigDecimal(source).movePointLeft(2);
    }
}
