package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Component
@RequiredArgsConstructor
class ExpenditureServiceImpl implements ExpenditureService {

    private final ModelMapper mapper;
    private final ExpenditureRepository repository;

    @Override
    public void add(Expenditure expenditure) {
        ExpenditureEntity entity = mapper.map(expenditure, ExpenditureEntity.class);
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public List<Expenditure> listAll() {
        return stream(repository.findAll().spliterator(), false)
            .map(entity -> mapper.map(entity, Expenditure.class))
            .collect(toList());
    }
}
