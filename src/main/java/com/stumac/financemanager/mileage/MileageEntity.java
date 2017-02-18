package com.stumac.financemanager.mileage;

import com.stumac.financemanager.user.data.UserDataEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mileage")
public class MileageEntity extends UserDataEntity
{
    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "end", nullable = false)
    private String end;

    @Column(name = "start", nullable = false)
    private String start;
}
