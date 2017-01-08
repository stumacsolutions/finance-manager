package com.stumac.financemanager.service.income;

import com.stumac.financemanager.service.common.UserData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;
import static org.springframework.format.annotation.NumberFormat.Style.CURRENCY;

@Getter
@Setter
public class Income extends UserData {

    @Min(0)
    @NotNull
    @NumberFormat(style = CURRENCY)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal amount;

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DATE)
    private LocalDate date = now();

    @NotNull
    @NotEmpty
    private String source;
}
