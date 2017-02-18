package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractUserDataRestController;
import com.stumac.financemanager.service.income.Income;
import com.stumac.financemanager.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/income", produces = HAL_JSON_VALUE)
class IncomeRestController extends AbstractUserDataRestController<Income>
{

    @Autowired
    public IncomeRestController(IncomeService service)
    {
        super(service);
    }
}
