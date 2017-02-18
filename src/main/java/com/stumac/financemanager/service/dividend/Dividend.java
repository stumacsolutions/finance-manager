package com.stumac.financemanager.service.dividend;

import com.stumac.financemanager.service.common.UserData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static org.springframework.format.annotation.NumberFormat.Style.CURRENCY;

@Getter
@Setter
public class Dividend extends UserData
{

    @Min(0)
    @NotNull
    @NumberFormat(style = CURRENCY)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal amount;
}
