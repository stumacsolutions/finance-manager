package com.stumac.financemanager.vat;

import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.togglz.spring.web.FeaturesAreActive;

@Controller
@RequestMapping(path = "/vat")
@FeaturesAreActive(featureClass = Features.class, features = "VAT")
public class VatController extends AbstractUserDataController<Vat>
{
    @Autowired
    public VatController(VatService service)
    {
        super(service, Vat.class);
    }
}
