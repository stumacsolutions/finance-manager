package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureEntity;
import com.stumac.financemanager.data.expenditure.ExpenditureRepository;
import com.stumac.financemanager.security.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        entity.setUser(getUser());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<Expenditure> get(long id) {
        Optional<ExpenditureEntity> maybeEntity = repository.findOneByIdAndUser(id, getUser());
        return maybeEntity.isPresent() ?
            Optional.of(mapper.map(maybeEntity.get(), Expenditure.class)) :
            Optional.empty();
    }

    @Override
    public List<Expenditure> listAll() {
        Iterable<ExpenditureEntity> expenditures = repository.findAllByUser(getUser());
        return stream(expenditures.spliterator(), false)
            .map(entity -> mapper.map(entity, Expenditure.class))
            .collect(toList());
    }

    private User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        return (User) principal;
    }
}
