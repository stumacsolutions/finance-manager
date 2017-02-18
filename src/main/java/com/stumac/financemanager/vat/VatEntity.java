package com.stumac.financemanager.vat;

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
@Entity(name = "vat")
public class VatEntity extends UserDataEntity
{
    @Column(name = "amount", nullable = false)
    private int amount;
}
