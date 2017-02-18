package com.stumac.financemanager.home;

import com.stumac.financemanager.accounts.ProfitAndLossRestController;
import com.stumac.financemanager.dividends.DividendRestController;
import com.stumac.financemanager.expenditure.ExpenditureRestController;
import com.stumac.financemanager.features.Features;
import com.stumac.financemanager.income.IncomeRestController;
import com.stumac.financemanager.mileage.MileageRestController;
import com.stumac.financemanager.vat.VatRestController;
import com.stumac.financemanager.web.AbstractRestController;
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
public class ApiController extends AbstractRestController
{
    @GetMapping(path = "")
    public ResponseEntity<ResourceSupport> home(Model model)
    {
        ResourceSupport resource = new ResourceSupport();
        linkToDividendsController(resource);
        linkToExpenditureController(resource);
        linkToIncomeController(resource);
        linkToMileageController(resource);
        linkToProfitAndLossController(resource);
        linkToVatController(resource);
        resource.add(getSelfLink());
        return ok(resource);
    }

    private void linkToDividendsController(ResourceSupport resource)
    {
        if (Features.DIVIDENDS.isActive())
        {
            resource.add(
                linkTo(methodOn(DividendRestController.class).listAll())
                    .withRel("dividends"));
        }
    }

    private void linkToExpenditureController(ResourceSupport resource)
    {
        resource.add(
            linkTo(methodOn(ExpenditureRestController.class).listAll())
                .withRel("expenditure"));
    }

    private void linkToIncomeController(ResourceSupport resource)
    {
        resource.add(
            linkTo(methodOn(IncomeRestController.class).listAll())
                .withRel("income"));
    }

    private void linkToMileageController(ResourceSupport resource)
    {
        resource.add(
            linkTo(methodOn(MileageRestController.class).listAll())
                .withRel("mileage"));
    }

    private void linkToProfitAndLossController(ResourceSupport resource)
    {
        resource.add(
            linkTo(methodOn(ProfitAndLossRestController.class).generate())
                .withRel("profit-and-loss"));
    }

    private void linkToVatController(ResourceSupport resource)
    {
        if (Features.VAT.isActive())
        {
            resource.add(
                linkTo(methodOn(VatRestController.class).listAll())
                    .withRel("vat"));
        }
    }
}
