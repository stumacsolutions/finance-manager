package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository extends UserDataRepository<ExpenditureEntity> {
}
