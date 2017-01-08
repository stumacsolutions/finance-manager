package com.stumac.financemanager.service.mileage;

import com.stumac.financemanager.service.common.UserData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Getter
@Setter
public class Mileage extends UserData {

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DATE)
    private LocalDate date = now();

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
