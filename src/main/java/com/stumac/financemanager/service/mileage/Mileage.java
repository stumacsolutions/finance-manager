package com.stumac.financemanager.service.mileage;

import com.stumac.financemanager.service.common.UserData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class Mileage extends UserData
{
    @Min(0)
    @NotNull
    @Digits(integer = 6, fraction = 3)
    private BigDecimal distance;

    @NotNull
    @NotEmpty
    private String end;

    @NotNull
    @NotEmpty
    private String start;
}
