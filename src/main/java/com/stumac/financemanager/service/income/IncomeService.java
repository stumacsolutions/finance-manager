package com.stumac.financemanager.service.income;

import com.stumac.financemanager.data.income.IncomeSource;
import com.stumac.financemanager.service.common.UserDataService;

import java.util.Collection;
import java.util.List;

public interface IncomeService extends UserDataService<Income>
{
    Collection<Income> listBySources(List<IncomeSource> sourceList);
}
