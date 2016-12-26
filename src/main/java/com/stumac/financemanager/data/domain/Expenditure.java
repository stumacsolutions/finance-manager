package com.stumac.financemanager.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expenditure {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExpenditureCategory category;

    @Lob
    @Column(name = "comments")
    private String comments;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "receipt", nullable = false)
    private boolean receipt;
}
