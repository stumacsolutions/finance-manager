package com.stumac.financemanager.mileage;

import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mileage")
public class MileageController extends AbstractUserDataController<Mileage>
{
    @Autowired
    public MileageController(MileageService service)
    {
        super(service, Mileage.class);
    }
}
