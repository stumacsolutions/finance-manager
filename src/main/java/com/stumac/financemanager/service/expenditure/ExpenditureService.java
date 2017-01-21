package com.stumac.financemanager.service.expenditure;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.service.common.UserDataService;

import java.util.Collection;
import java.util.List;

public interface ExpenditureService extends UserDataService<Expenditure> {

    Collection<Expenditure> listByCategories(List<ExpenditureCategory> categoryList);
}
