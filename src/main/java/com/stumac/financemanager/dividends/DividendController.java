package com.stumac.financemanager.dividends;

import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.togglz.spring.web.FeaturesAreActive;

@Controller
@RequestMapping(path = "/dividends")
@FeaturesAreActive(featureClass = Features.class, features = "DIVIDENDS")
public class DividendController extends AbstractUserDataController<Dividend>
{
    @Autowired
    public DividendController(DividendService service)
    {
        super(service, Dividend.class);
    }
}
