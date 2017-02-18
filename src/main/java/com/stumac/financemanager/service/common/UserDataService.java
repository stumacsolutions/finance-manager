package com.stumac.financemanager.service.common;

import java.util.List;
import java.util.Optional;

public interface UserDataService<D extends UserData>
{

    void add(D expenditure);

    void delete(long id);

    Optional<D> get(long id);

    List<D> listAll();
}
