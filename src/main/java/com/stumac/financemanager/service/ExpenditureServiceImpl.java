package com.stumac.financemanager.service;

import com.stumac.financemanager.data.ExpenditureRepository;
import com.stumac.financemanager.data.domain.ExpenditureCategory;
import com.stumac.financemanager.service.domain.Expenditure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExpenditureServiceImpl implements ExpenditureService {

    private final ExpenditureRepository repository;

    @Override
    public void submitExpenditure(Expenditure expenditure) {
        com.stumac.financemanager.data.domain.Expenditure entity =
            com.stumac.financemanager.data.domain.Expenditure.builder()
                .amount(getAmount(expenditure))
                .category(ExpenditureCategory.valueOf(expenditure.getCategory()))
                .comments(expenditure.getComments())
                .date(expenditure.getDate())
                .receipt(expenditure.getReceipt())
                .build();
        repository.save(entity);
    }

    private int getAmount(Expenditure expenditure) {
        Double v = expenditure.getAmount() * 100;
        return v.intValue();
    }
}
