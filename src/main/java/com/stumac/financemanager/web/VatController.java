package com.stumac.financemanager.web;

import com.stumac.financemanager.service.vat.Vat;
import com.stumac.financemanager.service.vat.VatService;
import com.stumac.financemanager.web.common.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vat")
class VatController extends AbstractUserDataController<Vat>
{
    @Autowired
    public VatController(VatService service)
    {
        super(service, Vat.class);
    }
}
