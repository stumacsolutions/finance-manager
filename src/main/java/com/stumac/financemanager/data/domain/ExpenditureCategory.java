package com.stumac.financemanager.data.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenditureCategory {

    BOOKS("Books"),
    HOME_OFFICE("Home Office"),
    MILEAGE("Mileage"),
    PHONE_BILL("Phone Bill"),
    TRAIN_TICKET("Train Ticket");

    private final String displayName;

    public String getId() {
        return name();
    }
}
