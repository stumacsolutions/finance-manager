package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractUserDataRestController;
import com.stumac.financemanager.service.expenditure.Expenditure;
import com.stumac.financemanager.service.expenditure.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/expenditure", produces = HAL_JSON_VALUE)
class ExpenditureRestController extends AbstractUserDataRestController<Expenditure> {

    @Autowired
    public ExpenditureRestController(ExpenditureService service) {
        super(service);
    }
}
