package com.stumac.financemanager.web;

import com.stumac.financemanager.service.dividend.Dividend;
import com.stumac.financemanager.service.dividend.DividendService;
import com.stumac.financemanager.web.common.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/dividend")
class DividendController extends AbstractUserDataController<Dividend>
{

    @Autowired
    public DividendController(DividendService service)
    {
        super(service, Dividend.class);
    }
}
