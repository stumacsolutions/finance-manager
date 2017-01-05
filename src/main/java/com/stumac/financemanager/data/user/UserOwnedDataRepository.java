package com.stumac.financemanager.data.user;

import com.stumac.financemanager.security.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface UserOwnedDataRepository<T extends UserOwnedDataEntity> extends PagingAndSortingRepository<T, Long> {

    Iterable<T> findAllByUser(User user);

    Optional<T> findOneByIdAndUser(long id, User user);
}
