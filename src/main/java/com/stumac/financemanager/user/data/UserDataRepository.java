package com.stumac.financemanager.user.data;

import com.stumac.financemanager.security.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface UserDataRepository<E extends UserDataEntity> extends PagingAndSortingRepository<E, Long>
{
    Iterable<E> findAllByUserOrderByDateAsc(User user);

    Optional<E> findOneByIdAndUser(long id, User user);
}
