package com.stumac.financemanager.income;

import com.stumac.financemanager.security.User;
import com.stumac.financemanager.user.data.UserDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends UserDataRepository<IncomeEntity>
{
    Iterable<IncomeEntity> findByUserAndSourceIn(User user, List<IncomeSource> sourceList);
}
