package com.stumac.financemanager.service.user;

import java.util.List;
import java.util.Optional;

public interface UserOwnedDataService<T extends UserOwnedData> {

    void add(T expenditure);

    void delete(long id);

    Optional<T> get(long id);

    List<T> listAll();
}
