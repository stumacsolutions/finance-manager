package com.stumac.financemanager.data.dividend;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendRepository extends UserDataRepository<DividendEntity>
{
}
