package com.stumac.financemanager.service.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Getter
@Setter
public abstract class UserData {

    private long id;

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DATE)
    private LocalDate date = now();
}
