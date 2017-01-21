package com.stumac.financemanager.data.expenditure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenditureCategory {

    BOOKS("Books", true),
    CORPORATION_TAX("Corporation Tax", false),
    DIVIDEND("Dividend", false),
    EMPLOYER_PAYE("PAYE for Employers", false),
    HOME_OFFICE("Home Office", false),
    INSURANCE("Insurance", false),
    MILEAGE("Mileage", true),
    PENSION("Pension", false),
    PHONE_BILL("Phone Bill", false),
    SALARY("Salary", false),
    TRAIN_TICKET("Train Ticket", true),
    VAT("VAT", false);

    private final String displayName;
    private final boolean isCostOfSale;

    public String getId() {
        return name();
    }
}
