package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "expenditure")
public class ExpenditureEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Enumerated(value = STRING)
    @Column(name = "category", nullable = false)
    private ExpenditureCategory category;

    @Lob
    @Column(name = "comments")
    private String comments;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "receipt", nullable = false)
    private boolean receipt;

    @ManyToOne(optional = false)
    private User user;
}
