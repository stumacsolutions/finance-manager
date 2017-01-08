package com.stumac.financemanager.data.mileage;

import com.stumac.financemanager.data.common.UserDataEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mileage")
public class MileageEntity extends UserDataEntity {

    @Lob
    @Column(name = "comments")
    private String comments;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "end", nullable = false)
    private String end;

    @Column(name = "start", nullable = false)
    private String start;
}
