package com.stumac.financemanager.web;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.service.expenditure.Expenditure;
import com.stumac.financemanager.service.expenditure.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
class ExpenditureController {

    private final ExpenditureService service;

    @GetMapping(path = "/expenditure")
    public String form(Model model) {
        model.addAttribute("categories", ExpenditureCategory.values());
        model.addAttribute("expenditure", new Expenditure());
        return "expenditure";
    }

    @PostMapping(path = "/expenditure")
    public String submit(@Valid Expenditure expenditure, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", ExpenditureCategory.values());
            model.addAttribute("expenditure", expenditure);
            return "expenditure";
        } else {
            service.submitExpenditure(expenditure);
            return "redirect:/expenditure";
        }
    }
}
