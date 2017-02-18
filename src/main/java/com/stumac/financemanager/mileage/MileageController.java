package com.stumac.financemanager.mileage;

import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.togglz.spring.web.FeaturesAreActive;

@Controller
@RequestMapping(path = "/mileage")
@FeaturesAreActive(featureClass = Features.class, features = "MILEAGE")
public class MileageController extends AbstractUserDataController<Mileage>
{
    @Autowired
    public MileageController(MileageService service)
    {
        super(service, Mileage.class);
    }
}
