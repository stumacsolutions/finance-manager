package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.data.common.UserDataRepository;
import com.stumac.financemanager.security.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends UserDataRepository<ExpenditureEntity> {

    Iterable<ExpenditureEntity> findByUserAndCategoryIn(User user, List<ExpenditureCategory> categoryList);
}
