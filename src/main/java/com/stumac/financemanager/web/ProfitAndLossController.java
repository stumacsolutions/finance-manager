package com.stumac.financemanager.web;

import com.stumac.financemanager.service.accounts.ProfitAndLossService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/profit-and-loss")
class ProfitAndLossController {

    private final ProfitAndLossService service;

    @GetMapping(path = "")
    public String manage(Model model) {
        model.addAttribute(service.generate());
        return "accounts/profitAndLoss";
    }

    @ModelAttribute("navigationSection")
    public String getNavigationSection() {
        return "profit-and-loss";
    }
}
