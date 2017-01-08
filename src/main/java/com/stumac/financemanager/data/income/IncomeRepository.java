package com.stumac.financemanager.data.income;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends UserDataRepository<IncomeEntity> {
}
