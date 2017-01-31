package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractUserDataRestController;
import com.stumac.financemanager.service.vat.Vat;
import com.stumac.financemanager.service.vat.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/vat", produces = HAL_JSON_VALUE)
class VatRestController extends AbstractUserDataRestController<Vat> {

    @Autowired
    public VatRestController(VatService service) {
        super(service);
    }
}
