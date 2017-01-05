package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ExpenditureServiceImpl extends UserDataServiceImpl<ExpenditureEntity, Expenditure> implements ExpenditureService {

    @Autowired
    public ExpenditureServiceImpl(ModelMapper mapper, ExpenditureRepository repository) {
        super(mapper, repository, Expenditure.class, ExpenditureEntity.class);
    }
}
