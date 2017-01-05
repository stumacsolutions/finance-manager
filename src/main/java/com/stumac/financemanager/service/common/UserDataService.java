package com.stumac.financemanager.service.common;

import java.util.List;
import java.util.Optional;

public interface UserDataService<T extends UserData> {

    void add(T expenditure);

    void delete(long id);

    Optional<T> get(long id);

    List<T> listAll();
}
