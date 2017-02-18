package com.stumac.financemanager.expenditure;

import com.stumac.financemanager.user.data.AbstractUserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/expenditure")
public class ExpenditureController extends AbstractUserDataController<Expenditure>
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
