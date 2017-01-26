package com.stumac.financemanager.service.income;

import com.stumac.financemanager.data.income.IncomeEntity;
import com.stumac.financemanager.data.income.IncomeRepository;
import com.stumac.financemanager.data.income.IncomeSource;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Component
class IncomeServiceImpl extends UserDataServiceImpl<IncomeEntity, Income> implements IncomeService {

    private final IncomeRepository repository;

    @Autowired
    public IncomeServiceImpl(ModelMapper mapper, IncomeRepository repository) {
        super(mapper, repository, Income.class, IncomeEntity.class);
        this.repository = repository;
    }

    @Override
    public Collection<Income> listBySources(List<IncomeSource> sourceList) {
        Iterable<IncomeEntity> entities = repository.findByUserAndSourceIn(getCurrentUser(), sourceList);
        return stream(entities.spliterator(), false)
            .map(this::map)
            .collect(toList());
    }
}
