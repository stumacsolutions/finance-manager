package com.stumac.financemanager.expenditure;

import com.stumac.financemanager.user.data.UserDataService;

import java.util.Collection;
import java.util.List;

public interface ExpenditureService extends UserDataService<Expenditure>
{
    Collection<Expenditure> listByCategories(List<ExpenditureCategory> categoryList);
}
