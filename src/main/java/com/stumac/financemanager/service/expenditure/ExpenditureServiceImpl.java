package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Component
class ExpenditureServiceImpl extends UserDataServiceImpl<ExpenditureEntity, Expenditure> implements ExpenditureService {

    private final ExpenditureRepository repository;

    @Autowired
    public ExpenditureServiceImpl(ModelMapper mapper, ExpenditureRepository repository) {
        super(mapper, repository, Expenditure.class, ExpenditureEntity.class);
        this.repository = repository;
    }

    @Override
    public Collection<Expenditure> listByCategories(List<ExpenditureCategory> categoryList) {
        Iterable<ExpenditureEntity> entities = repository.findByCategoryIn(categoryList);
        return stream(entities.spliterator(), false)
            .map(this::map)
            .collect(toList());
    }
}
