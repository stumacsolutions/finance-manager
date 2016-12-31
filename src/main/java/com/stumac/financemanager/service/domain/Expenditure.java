package com.stumac.financemanager.service.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static java.lang.Boolean.TRUE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;
import static org.springframework.format.annotation.NumberFormat.Style.CURRENCY;

@Getter
@Setter
public class Expenditure {

    @Min(0)
    @NotNull
    @NumberFormat(style = CURRENCY)
    private Double amount;

    @NotNull
    @NotEmpty
    private String category;

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DATE)
    private LocalDate date;

    @NotNull
    private Boolean receipt = TRUE;
}
