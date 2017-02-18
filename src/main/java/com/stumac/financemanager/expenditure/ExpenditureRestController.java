package com.stumac.financemanager.expenditure;

import com.stumac.financemanager.user.data.AbstractUserDataRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/expenditure", produces = HAL_JSON_VALUE)
public class ExpenditureRestController extends AbstractUserDataRestController<Expenditure>
{
    @Autowired
    public ExpenditureRestController(ExpenditureService service)
    {
        super(service);
    }
}
