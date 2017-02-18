package com.stumac.financemanager.dividends;

import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/dividends")
public class DividendController extends AbstractUserDataController<Dividend>
{
    @Autowired
    public DividendController(DividendService service)
    {
        super(service, Dividend.class);
    }
}
