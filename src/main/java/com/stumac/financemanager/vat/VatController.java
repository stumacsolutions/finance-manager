package com.stumac.financemanager.vat;

import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vat")
public class VatController extends AbstractUserDataController<Vat>
{
    @Autowired
    public VatController(VatService service)
    {
        super(service, Vat.class);
    }
}
