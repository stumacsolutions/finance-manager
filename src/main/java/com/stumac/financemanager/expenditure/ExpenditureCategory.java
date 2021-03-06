package com.stumac.financemanager.expenditure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenditureCategory
{
    BOOKS("Books", true),
    CORPORATION_TAX("Corporation Tax", false),
    EMPLOYER_PAYE("PAYE for Employers", false),
    HOME_OFFICE("Home Office", false),
    INSURANCE("Insurance", false),
    MILEAGE("Mileage", false),
    PENSION("Pension", false),
    PHONE_BILL("Phone Bill", false),
    REGISTRATION("Registration", false),
    SALARY("Salary", false),
    TRAIN_TICKET("Train Ticket", false),
    VAT("VAT", false);

    private final String displayName;
    private final boolean costOfSale;

    public String getId()
    {
        return name();
    }
}
