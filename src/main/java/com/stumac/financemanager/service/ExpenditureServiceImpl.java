package com.stumac.financemanager.service;

import com.stumac.financemanager.data.ExpenditureRepository;
import com.stumac.financemanager.service.domain.Expenditure;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ExpenditureServiceImpl implements ExpenditureService {

    private final ModelMapper mapper;
    private final ExpenditureRepository repository;

    @Override
    public void submitExpenditure(Expenditure expenditure) {
        com.stumac.financemanager.data.domain.Expenditure entity =
            mapper.map(expenditure, com.stumac.financemanager.data.domain.Expenditure.class);
        repository.save(entity);
    }
}
