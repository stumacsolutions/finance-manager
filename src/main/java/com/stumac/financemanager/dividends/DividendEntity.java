package com.stumac.financemanager.dividends;

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
@Entity(name = "dividends")
public class DividendEntity extends UserDataEntity
{
    @Column(name = "amount", nullable = false)
    private int amount;
}
