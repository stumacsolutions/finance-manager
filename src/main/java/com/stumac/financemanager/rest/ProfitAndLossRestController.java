package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractRestController;
import com.stumac.financemanager.service.accounts.ProfitAndLoss;
import com.stumac.financemanager.service.accounts.ProfitAndLossService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/profit-and-loss", produces = HAL_JSON_VALUE)
class ProfitAndLossRestController extends AbstractRestController
{
    private final ProfitAndLossService service;

    @GetMapping(path = "")
    public ResponseEntity<Resource<ProfitAndLoss>> generate()
    {
        Resource<ProfitAndLoss> resource = new Resource<>(service.generate());
        resource.add(getSelfLink());
        return ok(resource);
    }
}
