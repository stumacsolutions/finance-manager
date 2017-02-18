package com.stumac.financemanager.rest.common;

import com.stumac.financemanager.service.common.UserData;
import com.stumac.financemanager.service.common.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
public abstract class AbstractUserDataRestController<D extends UserData> extends AbstractRestController
{

    private final UserDataService<D> service;

    @GetMapping(path = "")
    public ResponseEntity<Resources<D>> listAll()
    {
        Resources<D> resources = new Resources<>(service.listAll());
        resources.add(getSelfLink());
        return ok(resources);
    }
}
