package com.stumac.financemanager.data.income;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends UserDataRepository<IncomeEntity> {

    Iterable<IncomeEntity> findBySourceIn(List<IncomeSource> sourceList);
}
