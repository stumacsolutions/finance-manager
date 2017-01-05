package com.stumac.financemanager.data.user;

import com.stumac.financemanager.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserOwnedDataEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private User user;
}
