package com.stumac.financemanager.data.dividend;

import com.stumac.financemanager.data.common.UserDataEntity;
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
@Entity(name = "dividend")
public class DividendEntity extends UserDataEntity {

    @Column(name = "amount", nullable = false)
    private int amount;
}
