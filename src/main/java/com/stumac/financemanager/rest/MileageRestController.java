package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractUserDataRestController;
import com.stumac.financemanager.service.mileage.Mileage;
import com.stumac.financemanager.service.mileage.MileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/mileage", produces = HAL_JSON_VALUE)
class MileageRestController extends AbstractUserDataRestController<Mileage>
{

    @Autowired
    public MileageRestController(MileageService service)
    {
        super(service);
    }
}
