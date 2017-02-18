package com.stumac.financemanager.vat;

import com.stumac.financemanager.user.data.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatRepository extends UserDataRepository<VatEntity>
{
}
