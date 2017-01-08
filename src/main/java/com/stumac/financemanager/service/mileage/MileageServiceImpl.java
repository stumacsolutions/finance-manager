package com.stumac.financemanager.service.mileage;

import com.stumac.financemanager.data.mileage.MileageEntity;
import com.stumac.financemanager.data.mileage.MileageRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MileageServiceImpl extends UserDataServiceImpl<MileageEntity, Mileage> implements MileageService {

    @Autowired
    public MileageServiceImpl(ModelMapper mapper, MileageRepository repository) {
        super(mapper, repository, Mileage.class, MileageEntity.class);
    }
}
