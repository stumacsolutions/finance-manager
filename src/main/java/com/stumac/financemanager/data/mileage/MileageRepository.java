package com.stumac.financemanager.data.mileage;

import com.stumac.financemanager.data.common.UserDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageRepository extends UserDataRepository<MileageEntity> {
}
