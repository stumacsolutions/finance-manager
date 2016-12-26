package com.stumac.financemanager.data;

import com.stumac.financemanager.data.domain.Expenditure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository extends PagingAndSortingRepository<Expenditure, Long> {
}
