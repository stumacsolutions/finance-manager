package com.stumac.financemanager.web;

import com.stumac.financemanager.security.User;
import com.stumac.financemanager.service.user.UserProfile;
import com.stumac.financemanager.service.user.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user/profile")
class UserProfileController {

    private final UserProfileService service;

    @GetMapping(path = "/edit")
    public String edit(@AuthenticationPrincipal User user, Model model) {
        Optional<UserProfile> maybeProfile = service.get();
        UserProfile profile = maybeProfile.isPresent() ? maybeProfile.get() : new UserProfile();
        model.addAttribute("userProfile", profile);
        return "user/profile/edit";
    }

    @PostMapping(path = "/save")
    public String save(@Valid UserProfile userProfile, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userProfile", userProfile);
            return "user/profile/edit";
        } else {
            service.save(userProfile);
            return "redirect:/";
        }
    }
}
