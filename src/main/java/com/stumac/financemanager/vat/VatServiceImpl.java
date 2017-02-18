package com.stumac.financemanager.vat;

import com.stumac.financemanager.user.data.AbstractUserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class VatServiceImpl extends AbstractUserDataServiceImpl<VatEntity, Vat> implements VatService
{
    @Autowired
    public VatServiceImpl(ModelMapper mapper, VatRepository repository)
    {
        super(mapper, repository, Vat.class, VatEntity.class);
    }
}
