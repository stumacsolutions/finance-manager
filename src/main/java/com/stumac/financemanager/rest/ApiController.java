package com.stumac.financemanager.rest;

import com.stumac.financemanager.rest.common.AbstractRestController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/api", produces = HAL_JSON_VALUE)
class ApiController extends AbstractRestController {

    @GetMapping(path = "")
    public ResponseEntity<ResourceSupport> home(Model model) {
        ResourceSupport resource = new ResourceSupport();
        resource.add(
            linkTo(methodOn(ExpenditureRestController.class).listAll())
                .withRel("expenditure"));
        resource.add(
            linkTo(methodOn(IncomeRestController.class).listAll())
                .withRel("income"));
        resource.add(
            linkTo(methodOn(MileageRestController.class).listAll())
                .withRel("mileage"));
        resource.add(
            linkTo(methodOn(ProfitAndLossRestController.class).generate())
                .withRel("profit-and-loss"));
        resource.add(getSelfLink());
        return ok(resource);
    }
}
