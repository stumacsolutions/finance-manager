package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends UserDataRepository<ExpenditureEntity> {

    Iterable<ExpenditureEntity> findByCategoryIn(List<ExpenditureCategory> categoryList);
}
