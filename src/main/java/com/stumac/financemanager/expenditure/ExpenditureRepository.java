package com.stumac.financemanager.expenditure;

import com.stumac.financemanager.security.User;
import com.stumac.financemanager.user.data.UserDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends UserDataRepository<ExpenditureEntity>
{
    Iterable<ExpenditureEntity> findByUserAndCategoryIn(User user, List<ExpenditureCategory> categoryList);
}
