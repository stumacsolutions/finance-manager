package com.stumac.financemanager.mileage;

import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.user.data.AbstractUserDataRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.spring.web.FeaturesAreActive;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/mileage", produces = HAL_JSON_VALUE)
@FeaturesAreActive(featureClass = Features.class, features = "MILEAGE")
public class MileageRestController extends AbstractUserDataRestController<Mileage>
{
    @Autowired
    public MileageRestController(MileageService service)
    {
        super(service);
    }
}
