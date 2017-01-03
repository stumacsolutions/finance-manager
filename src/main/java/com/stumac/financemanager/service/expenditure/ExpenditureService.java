package com.stumac.financemanager.service.expenditure;

import java.util.List;

public interface ExpenditureService {

    void add(Expenditure expenditure);

    void delete(long id);

    List<Expenditure> listAll();
}
