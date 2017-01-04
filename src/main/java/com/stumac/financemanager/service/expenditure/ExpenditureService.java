package com.stumac.financemanager.service.expenditure;

import java.util.List;
import java.util.Optional;

public interface ExpenditureService {

    void add(Expenditure expenditure);

    void delete(long id);

    Optional<Expenditure> get(long id);

    List<Expenditure> listAll();
}
