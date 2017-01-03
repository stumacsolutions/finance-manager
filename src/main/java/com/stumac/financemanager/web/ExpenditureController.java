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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/expenditure")
class ExpenditureController {

    private final ExpenditureService service;

    @GetMapping(path = "/add")
    public String getAddExpenditureForm(Model model) {
        model.addAttribute("expenditure", new Expenditure());
        return "expenditure/add";
    }

    @GetMapping(path = "/manage")
    public String getManageExpenditureForm(Model model) {
        model.addAttribute("expenditures", service.listAll());
        return "expenditure/manage";
    }

    @PostMapping(path = "/add")
    public String addExpenditure(@Valid Expenditure expenditure, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenditure", expenditure);
            return "expenditure/add";
        } else {
            service.add(expenditure);
            return "redirect:/expenditure/manage";
        }
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteExpenditure(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/expenditure/manage";
    }

    @ModelAttribute("categories")
    public ExpenditureCategory[] getCategories() {
        return ExpenditureCategory.values();
    }
}
