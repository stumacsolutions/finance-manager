package com.stumac.financemanager.service.vat;

import com.stumac.financemanager.data.vat.VatEntity;
import com.stumac.financemanager.data.vat.VatRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class VatServiceImpl extends UserDataServiceImpl<VatEntity, Vat> implements VatService {

    @Autowired
    public VatServiceImpl(ModelMapper mapper, VatRepository repository) {
        super(mapper, repository, Vat.class, VatEntity.class);
    }
}
