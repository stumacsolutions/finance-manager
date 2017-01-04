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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/expenditure")
class ExpenditureController {

    private final ExpenditureService service;

    @GetMapping(path = "/manage")
    public String manage(Model model) {
        model.addAttribute("expenditures", service.listAll());
        return "expenditure/manage";
    }

    @GetMapping(path = "/add")
    public String add(Model model) {
        model.addAttribute("expenditure", new Expenditure());
        return "expenditure/edit";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable(name = "id") long id, Model model) {
        Optional<Expenditure> maybeExpenditure = service.get(id);
        if (maybeExpenditure.isPresent()) {
            model.addAttribute("expenditure", maybeExpenditure);
            return "expenditure/edit";
        }
        return "redirect:/expenditure/manage";
    }

    @PostMapping(path = "/save")
    public String save(@Valid Expenditure expenditure, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenditure", expenditure);
            return "expenditure/edit";
        } else {
            service.add(expenditure);
            return "redirect:/expenditure/manage";
        }
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/expenditure/manage";
    }

    @ModelAttribute("categories")
    public ExpenditureCategory[] getCategories() {
        return ExpenditureCategory.values();
    }
}
