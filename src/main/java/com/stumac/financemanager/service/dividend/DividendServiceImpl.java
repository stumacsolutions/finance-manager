package com.stumac.financemanager.service.dividend;

import com.stumac.financemanager.data.dividend.DividendEntity;
import com.stumac.financemanager.data.dividend.DividendRepository;
import com.stumac.financemanager.service.common.UserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DividendServiceImpl extends UserDataServiceImpl<DividendEntity, Dividend> implements DividendService {

    @Autowired
    public DividendServiceImpl(ModelMapper mapper, DividendRepository repository) {
        super(mapper, repository, Dividend.class, DividendEntity.class);
    }
}
