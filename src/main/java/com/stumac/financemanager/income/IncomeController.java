package com.stumac.financemanager.income;

import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/income")
public class IncomeController extends AbstractUserDataController<Income>
{
    @Autowired
    public IncomeController(IncomeService service)
    {
        super(service, Income.class);
    }

    @ModelAttribute("sources")
    public IncomeSource[] getCategories()
    {
        return IncomeSource.values();
    }
}
