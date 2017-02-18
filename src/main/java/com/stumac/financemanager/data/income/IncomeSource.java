package com.stumac.financemanager.data.income;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncomeSource
{
    INTEREST("Interest"),
    INVOICE("Invoice"),
    SHARES("Shares");

    private final String displayName;

    public String getId()
    {
        return name();
    }
}
