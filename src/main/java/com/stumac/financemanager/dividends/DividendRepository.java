package com.stumac.financemanager.dividends;

import com.stumac.financemanager.user.data.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendRepository extends UserDataRepository<DividendEntity>
{
}
