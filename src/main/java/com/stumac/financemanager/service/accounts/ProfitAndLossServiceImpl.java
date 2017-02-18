package com.stumac.financemanager.service.accounts;

import com.stumac.financemanager.data.expenditure.ExpenditureCategory;
import com.stumac.financemanager.data.income.IncomeSource;
import com.stumac.financemanager.service.expenditure.Expenditure;
import com.stumac.financemanager.service.expenditure.ExpenditureService;
import com.stumac.financemanager.service.income.Income;
import com.stumac.financemanager.service.income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.stumac.financemanager.data.income.IncomeSource.INTEREST;
import static com.stumac.financemanager.data.income.IncomeSource.INVOICE;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
class ProfitAndLossServiceImpl implements ProfitAndLossService
{

    private static final BigDecimal CORPORATION_TAX_RATE = BigDecimal.valueOf(0.20);
    private static final BigDecimal FLAT_VAT_RATE = BigDecimal.valueOf(0.135);

    private final ExpenditureService expenditureService;
    private final IncomeService incomeService;

    @Override
    public ProfitAndLoss generate()
    {
        BigDecimal turnover = calculateTurnover();
        BigDecimal costOfSales = calculateCostOfSales();
        BigDecimal grossProfit = calculateGrossProfit(turnover, costOfSales);
        BigDecimal distributionCosts = calculateDistributionCosts();
        BigDecimal administrativeExpenses = calculateAdministrativeExpenses();
        BigDecimal otherOperatingIncome = calculateOtherOperatingIncome();
        BigDecimal operatingProfit = calculateOperatingProfit(grossProfit, administrativeExpenses, otherOperatingIncome);
        BigDecimal interestReceivable = calculateInterestReceivable();
        BigDecimal interestPayable = calculateInterestPayable();
        BigDecimal profitBeforeTax = calculateProfitBeforeTax(operatingProfit, interestReceivable, interestPayable);
        BigDecimal taxOnProfit = calculateTaxOnProfit(profitBeforeTax);
        BigDecimal profit = calculateProfit(profitBeforeTax, taxOnProfit);
        return ProfitAndLoss.builder()
            .turnover(turnover)
            .costOfSales(costOfSales)
            .grossProfit(grossProfit)
            .distributionCosts(distributionCosts)
            .administrativeExpenses(administrativeExpenses)
            .otherOperatingIncome(otherOperatingIncome)
            .operatingProfit(operatingProfit)
            .interestReceivable(interestReceivable)
            .interestPayable(interestPayable)
            .profitBeforeTax(profitBeforeTax)
            .taxOnProfit(taxOnProfit)
            .profit(profit)
            .build();
    }

    private BigDecimal calculateTurnover()
    {
        BigDecimal invoiceIncome = calculateCombinedIncome(singletonList(INVOICE));
        BigDecimal vatPaid = invoiceIncome.multiply(FLAT_VAT_RATE).setScale(2, HALF_UP);
        return invoiceIncome.subtract(vatPaid);
    }

    private BigDecimal calculateCostOfSales()
    {
        return calculateCombinedExpenditure(
            stream(ExpenditureCategory.values())
                .filter(ExpenditureCategory::isCostOfSale)
                .collect(toList()));
    }

    private BigDecimal calculateGrossProfit(BigDecimal turnover, BigDecimal costOfSales)
    {
        return turnover.subtract(costOfSales);
    }

    private BigDecimal calculateDistributionCosts()
    {
        return ZERO;
    }

    private BigDecimal calculateAdministrativeExpenses()
    {
        return calculateCombinedExpenditure(
            stream(ExpenditureCategory.values())
                .filter(category -> !category.isCostOfSale())
                .collect(toList()));
    }

    private BigDecimal calculateOtherOperatingIncome()
    {
        return ZERO;
    }

    private BigDecimal calculateOperatingProfit(BigDecimal grossProfit, BigDecimal administrativeExpenses, BigDecimal otherOperatingIncome)
    {
        return grossProfit.subtract(administrativeExpenses).subtract(administrativeExpenses).add(otherOperatingIncome);
    }

    private BigDecimal calculateInterestReceivable()
    {
        return calculateCombinedIncome(singletonList(INTEREST));
    }

    private BigDecimal calculateInterestPayable()
    {
        return ZERO;
    }

    private BigDecimal calculateProfitBeforeTax(BigDecimal operatingProfit, BigDecimal interestReceivable, BigDecimal interestPayable)
    {
        return operatingProfit.add(interestReceivable).subtract(interestPayable);
    }

    private BigDecimal calculateTaxOnProfit(BigDecimal profitBeforeTax)
    {
        return profitBeforeTax.multiply(CORPORATION_TAX_RATE).setScale(2, HALF_UP);
    }

    private BigDecimal calculateProfit(BigDecimal profitBeforeTax, BigDecimal taxOnProfit)
    {
        return profitBeforeTax.subtract(taxOnProfit);
    }

    private BigDecimal calculateCombinedIncome(List<IncomeSource> sources)
    {
        return incomeService.listBySources(sources).stream()
            .map(Income::getAmount)
            .reduce(ZERO, BigDecimal::add);
    }

    private BigDecimal calculateCombinedExpenditure(List<ExpenditureCategory> categories)
    {
        return expenditureService.listByCategories(categories).stream()
            .map(Expenditure::getAmount)
            .reduce(ZERO, BigDecimal::add);
    }
}
