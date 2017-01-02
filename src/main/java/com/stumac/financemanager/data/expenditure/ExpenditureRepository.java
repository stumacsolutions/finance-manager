package com.stumac.financemanager.data.expenditure;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository extends PagingAndSortingRepository<ExpenditureEntity, Long> {
}
