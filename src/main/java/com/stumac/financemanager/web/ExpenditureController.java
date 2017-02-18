package com.stumac.financemanager.web;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.service.expenditure.Expenditure;
import com.stumac.financemanager.service.expenditure.ExpenditureService;
import com.stumac.financemanager.web.common.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/expenditure")
class ExpenditureController extends AbstractUserDataController<Expenditure>
{

    @Autowired
    public ExpenditureController(ExpenditureService service)
    {
        super(service, Expenditure.class);
    }

    @ModelAttribute("categories")
    public ExpenditureCategory[] getCategories()
    {
        return ExpenditureCategory.values();
    }
}
