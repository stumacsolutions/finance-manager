package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
import com.stumac.financemanager.service.user.UserOwnedDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ExpenditureServiceImpl extends UserOwnedDataServiceImpl<ExpenditureEntity, Expenditure> implements ExpenditureService {

    private final ModelMapper mapper;

    @Autowired
    public ExpenditureServiceImpl(ModelMapper mapper, ExpenditureRepository repository) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    protected ExpenditureEntity map(Expenditure source) {
        return mapper.map(source, ExpenditureEntity.class);
    }

    @Override
    protected Expenditure map(ExpenditureEntity source) {
        return mapper.map(source, Expenditure.class);
    }
}
