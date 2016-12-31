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

@Getter
@Setter
public class Expenditure {

    @Min(1)
    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double amount;

    @NotNull
    @NotEmpty
    private String category;

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotNull
    private Boolean receipt = TRUE;
}
