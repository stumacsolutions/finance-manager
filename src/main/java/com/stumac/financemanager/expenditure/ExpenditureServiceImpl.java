package com.stumac.financemanager.expenditure;

import com.stumac.financemanager.user.data.AbstractUserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Component
class ExpenditureServiceImpl extends AbstractUserDataServiceImpl<ExpenditureEntity, Expenditure> implements ExpenditureService
{
    private final ExpenditureRepository repository;

    @Autowired
    public ExpenditureServiceImpl(ModelMapper mapper, ExpenditureRepository repository)
    {
        super(mapper, repository, Expenditure.class, ExpenditureEntity.class);
        this.repository = repository;
    }

    @Override
    public Collection<Expenditure> listByCategories(List<ExpenditureCategory> categoryList)
    {
        Iterable<ExpenditureEntity> entities = repository.findByUserAndCategoryIn(getCurrentUser(), categoryList);
        return stream(entities.spliterator(), false)
            .map(this::map)
            .collect(toList());
    }
}
