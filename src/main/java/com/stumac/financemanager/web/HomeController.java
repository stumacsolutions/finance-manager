package com.stumac.financemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
class HomeController {

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @ModelAttribute("navigationSection")
    public String getNavigationSection() {
        return "home";
    }
}
