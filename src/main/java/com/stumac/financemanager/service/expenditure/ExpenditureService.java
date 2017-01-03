package com.stumac.financemanager.service.expenditure;

import java.util.List;

public interface ExpenditureService {

    void add(Expenditure expenditure);

    List<Expenditure> listAll();
}
