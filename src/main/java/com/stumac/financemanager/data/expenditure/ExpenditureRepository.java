package com.stumac.financemanager.data.expenditure;

import com.stumac.financemanager.data.user.UserOwnedDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureRepository extends UserOwnedDataRepository<ExpenditureEntity> {
}
