package com.stumac.financemanager.data.income;

import com.stumac.financemanager.data.common.UserDataRepository;
import com.stumac.financemanager.security.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends UserDataRepository<IncomeEntity>
{

    Iterable<IncomeEntity> findByUserAndSourceIn(User user, List<IncomeSource> sourceList);
}
