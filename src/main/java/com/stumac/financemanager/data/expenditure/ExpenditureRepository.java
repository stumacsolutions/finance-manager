package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.security.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenditureRepository extends PagingAndSortingRepository<ExpenditureEntity, Long> {

    Iterable<ExpenditureEntity> findAllByUser(User user);

    Optional<ExpenditureEntity> findOneByIdAndUser(long id, User user);
}
