package com.stumac.financemanager.web.common;

import com.stumac.financemanager.service.common.UserData;
import com.stumac.financemanager.service.common.UserDataService;
import com.stumac.financemanager.web.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

import static java.lang.String.format;

@RequiredArgsConstructor
public abstract class UserDataController<D extends UserData> {

    private final UserDataService<D> service;
    private final Class<D> serviceClass;

    @GetMapping(path = "/manage")
    public String manage(Model model) {
        model.addAttribute(format("%ss", getType()), service.listAll());
        return format("%s/manage", getType());
    }

    @SneakyThrows
    @GetMapping(path = "/add")
    public String add(Model model) {
        model.addAttribute(getType(), serviceClass.newInstance());
        return format("%s/edit", getType());
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute(getType(), getUserData(id));
        return format("%s/edit", getType());
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute(getType(), getUserData(id));
        return format("%s/delete", getType());
    }

    @PostMapping(path = "/delete/{id}")
    public String remove(@PathVariable(name = "id") long id) {
        service.delete(id);
        return format("redirect:/%s/manage", getType());
    }

    @PostMapping(path = "/save")
    public String save(@Valid D userData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(getType(), userData);
            return format("%s/edit", getType());
        } else {
            service.add(userData);
            return format("redirect:/%s/manage", getType());
        }
    }

    @ModelAttribute("navigationSection")
    public String getNavigationSection() {
        return getType();
    }

    private String getType() {
        return serviceClass.getSimpleName().toLowerCase();
    }

    private D getUserData(long id) {
        Optional<D> maybeUserData = service.get(id);
        if (maybeUserData.isPresent()) {
            return maybeUserData.get();
        }
        throw new ResourceNotFoundException();
    }
}
