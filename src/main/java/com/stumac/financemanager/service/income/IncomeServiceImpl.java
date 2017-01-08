package com.stumac.financemanager.service.income;

import com.stumac.financemanager.data.income.IncomeEntity;
import com.stumac.financemanager.data.income.IncomeRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class IncomeServiceImpl extends UserDataServiceImpl<IncomeEntity, Income> implements IncomeService {

    @Autowired
    public IncomeServiceImpl(ModelMapper mapper, IncomeRepository repository) {
        super(mapper, repository, Income.class, IncomeEntity.class);
    }
}
