package com.stumac.financemanager.vat;

import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.user.data.AbstractUserDataRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.spring.web.FeaturesAreActive;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/vat", produces = HAL_JSON_VALUE)
@FeaturesAreActive(featureClass = Features.class, features = "VAT")
public class VatRestController extends AbstractUserDataRestController<Vat>
{
    @Autowired
    public VatRestController(VatService service)
    {
        super(service);
    }
}
