package com.stumac.financemanager.web;

import com.stumac.financemanager.data.income.IncomeSource;
import com.stumac.financemanager.service.income.Income;
import com.stumac.financemanager.service.income.IncomeService;
import com.stumac.financemanager.web.common.UserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/income")
class IncomeController extends UserDataController<Income> {

    @Autowired
    public IncomeController(IncomeService service) {
        super(service, Income.class);
    }

    @ModelAttribute("sources")
    public IncomeSource[] getCategories() {
        return IncomeSource.values();
    }
}
