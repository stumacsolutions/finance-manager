package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
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
        ExpenditureEntity entity = mapper.map(expenditure, ExpenditureEntity.class);
        repository.save(entity);
    }
}
