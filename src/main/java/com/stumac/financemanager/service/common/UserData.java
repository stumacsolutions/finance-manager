package com.stumac.financemanager.service.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
public abstract class UserData
{

    private Long id;

    @Size(max = 250)
    private String comments;

    @NotNull
    @DateTimeFormat(iso = DATE)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date = now();
}
