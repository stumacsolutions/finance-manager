package com.stumac.financemanager.web;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.service.expenditure.Expenditure;
import com.stumac.financemanager.service.expenditure.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
class ExpenditureController {

    private final ExpenditureService service;

    @GetMapping(path = "/expenditure/add")
    public String getAddExpenditureForm(Model model) {
        model.addAttribute("expenditure", new Expenditure());
        return "expenditure/add";
    }

    @GetMapping(path = "/expenditure/manage")
    public String getManageExpenditureForm(Model model) {
        model.addAttribute("expenditures", service.listAll());
        return "expenditure/manage";
    }

    @PostMapping(path = "/expenditure/add")
    public String addExpenditure(@Valid Expenditure expenditure, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenditure", expenditure);
            return "expenditure/add";
        } else {
            service.add(expenditure);
            return "redirect:/expenditure/add";
        }
    }

    @ModelAttribute("categories")
    public ExpenditureCategory[] getCategories() {
        return ExpenditureCategory.values();
    }
}
