package com.stumac.financemanager.income;

import com.stumac.financemanager.user.data.UserDataService;

import java.util.Collection;
import java.util.List;

public interface IncomeService extends UserDataService<Income>
{
    Collection<Income> listBySources(List<IncomeSource> sourceList);
}
