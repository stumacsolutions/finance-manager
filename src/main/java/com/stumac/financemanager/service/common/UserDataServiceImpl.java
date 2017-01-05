package com.stumac.financemanager.service.common;

import com.stumac.financemanager.data.common.UserDataEntity;
import com.stumac.financemanager.data.common.UserDataRepository;
import com.stumac.financemanager.security.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@RequiredArgsConstructor
public abstract class UserDataServiceImpl<E extends UserDataEntity, D extends UserData>
    implements UserDataService<D> {

    private final ModelMapper mapper;
    private final UserDataRepository<E> repository;
    private final Class<D> domainClass;
    private final Class<E> entityClass;

    @Override
    public void add(D data) {
        E entity = map(data);
        entity.setUser(getUser());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<D> get(long id) {
        Optional<E> maybeEntity = repository.findOneByIdAndUser(id, getUser());
        return maybeEntity.isPresent() ?
            Optional.of(map(maybeEntity.get())) :
            Optional.empty();
    }

    @Override
    public List<D> listAll() {
        Iterable<E> data = repository.findAllByUser(getUser());
        return stream(data.spliterator(), false)
            .map(this::map)
            .collect(toList());
    }

    private E map(D source) {
        return mapper.map(source, entityClass);
    }

    private D map(E source) {
        return mapper.map(source, domainClass);
    }

    private User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        return (User) principal;
    }
}
