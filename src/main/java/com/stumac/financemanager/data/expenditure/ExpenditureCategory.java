package com.stumac.financemanager.data.expenditure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenditureCategory {

    BOOKS("Books"),
    CORPORATION_TAX("Corporation Tax"),
    DIVIDEND("Dividend"),
    EMPLOYER_PAYE("PAYE for Employers"),
    HOME_OFFICE("Home Office"),
    MILEAGE("Mileage"),
    PENSION("Pension"),
    PHONE_BILL("Phone Bill"),
    SALARY("Salary"),
    TRAIN_TICKET("Train Ticket"),
    VAT("VAT");

    private final String displayName;

    public String getId() {
        return name();
    }
}
