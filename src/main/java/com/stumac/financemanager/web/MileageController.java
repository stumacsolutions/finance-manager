package com.stumac.financemanager.web;

import com.stumac.financemanager.service.mileage.Mileage;
import com.stumac.financemanager.service.mileage.MileageService;
import com.stumac.financemanager.web.common.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mileage")
class MileageController extends AbstractUserDataController<Mileage>
{
    @Autowired
    public MileageController(MileageService service)
    {
        super(service, Mileage.class);
    }
}
