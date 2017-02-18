package com.stumac.financemanager.mileage;

import com.stumac.financemanager.user.data.AbstractUserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MileageServiceImpl extends AbstractUserDataServiceImpl<MileageEntity, Mileage> implements MileageService
{
    @Autowired
    public MileageServiceImpl(ModelMapper mapper, MileageRepository repository)
    {
        super(mapper, repository, Mileage.class, MileageEntity.class);
    }
}
