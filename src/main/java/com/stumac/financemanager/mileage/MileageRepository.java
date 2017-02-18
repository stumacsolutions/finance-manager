package com.stumac.financemanager.mileage;

import com.stumac.financemanager.user.data.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageRepository extends UserDataRepository<MileageEntity>
{
}
