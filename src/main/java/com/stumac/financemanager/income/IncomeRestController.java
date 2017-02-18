package com.stumac.financemanager.income;

import com.stumac.financemanager.user.data.AbstractUserDataRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/income", produces = HAL_JSON_VALUE)
public class IncomeRestController extends AbstractUserDataRestController<Income>
{
    @Autowired
    public IncomeRestController(IncomeService service)
    {
        super(service);
    }
}
