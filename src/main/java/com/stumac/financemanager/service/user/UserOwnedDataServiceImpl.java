package com.stumac.financemanager.service.user;

import com.stumac.financemanager.data.user.UserOwnedDataEntity;
import com.stumac.financemanager.data.user.UserOwnedDataRepository;
import com.stumac.financemanager.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@RequiredArgsConstructor
public abstract class UserOwnedDataServiceImpl<E extends UserOwnedDataEntity, T extends UserOwnedData>
    implements UserOwnedDataService<T> {

    private final UserOwnedDataRepository<E> repository;

    @Override
    public void add(T data) {
        E entity = map(data);
        entity.setUser(getUser());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Optional<T> get(long id) {
        Optional<E> maybeEntity = repository.findOneByIdAndUser(id, getUser());
        return maybeEntity.isPresent() ?
            Optional.of(map(maybeEntity.get())) :
            Optional.empty();
    }

    @Override
    public List<T> listAll() {
        Iterable<E> data = repository.findAllByUser(getUser());
        return stream(data.spliterator(), false)
            .map(this::map)
            .collect(toList());
    }

    protected abstract E map(T source);

    protected abstract T map(E source);

    private User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        return (User) principal;
    }
}
