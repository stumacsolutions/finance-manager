package com.stumac.financemanager.dividends;

import com.stumac.financemanager.user.data.AbstractUserDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DividendServiceImpl extends AbstractUserDataServiceImpl<DividendEntity, Dividend> implements DividendService
{
    @Autowired
    public DividendServiceImpl(ModelMapper mapper, DividendRepository repository)
    {
        super(mapper, repository, Dividend.class, DividendEntity.class);
    }
}
