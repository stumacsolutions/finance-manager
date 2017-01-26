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

import static com.stumac.financemanager.data.income.IncomeSource.INVOICE;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
class ProfitAndLossServiceImpl implements ProfitAndLossService {

    private static final BigDecimal CORPORATION_TAX_RATE = BigDecimal.valueOf(0.20);
    private static final BigDecimal FLAT_VAT_RATE = BigDecimal.valueOf(0.135);
    private static final BigDecimal VAT_RATE = BigDecimal.valueOf(0.20);

    private final ExpenditureService expenditureService;
    private final IncomeService incomeService;

    @Override
    public ProfitAndLoss generate() {
        BigDecimal sales = calculateSales();
        BigDecimal costOfSales = calculateCostOfSales();
        BigDecimal grossProfit = sales.subtract(costOfSales);
        BigDecimal otherIncome = calculateOtherIncome();
        BigDecimal expenses = calculateExpenses();
        BigDecimal profitBeforeTax = grossProfit.add(otherIncome).subtract(expenses);
        BigDecimal corporationTax = calculateCorporationTax(profitBeforeTax);
        BigDecimal netProfit = profitBeforeTax.subtract(corporationTax);
        return ProfitAndLoss.builder()
            .sales(sales)
            .costOfSales(costOfSales)
            .grossProfit(grossProfit)
            .otherIncome(otherIncome)
            .expenses(expenses)
            .profitBeforeTax(profitBeforeTax)
            .corporationTax(corporationTax)
            .netProfit(netProfit)
            .build();
    }

    private BigDecimal calculateSales() {
        return calculateCombinedIncome(singletonList(INVOICE))
            .divide(ONE.add(VAT_RATE), HALF_UP);
    }

    private BigDecimal calculateCostOfSales() {
        return calculateCombinedExpenditure(
            stream(ExpenditureCategory.values())
                .filter(ExpenditureCategory::isCostOfSale)
                .collect(toList()));
    }

    private BigDecimal calculateOtherIncome() {
        return calculateNonInvoiceIncome().add(calculateFlatRateProfit());
    }

    private BigDecimal calculateNonInvoiceIncome() {
        return calculateCombinedIncome(
            stream(IncomeSource.values())
                .filter(source -> source != INVOICE)
                .collect(toList()));
    }

    private BigDecimal calculateFlatRateProfit() {
        BigDecimal invoiceIncome = calculateCombinedIncome(singletonList(INVOICE));
        return invoiceIncome
            .subtract(invoiceIncome.multiply(FLAT_VAT_RATE))
            .subtract(calculateSales())
            .setScale(2, HALF_UP);
    }

    private BigDecimal calculateCombinedIncome(List<IncomeSource> sources) {
        return incomeService.listBySources(sources).stream()
            .map(Income::getAmount)
            .reduce(ZERO, BigDecimal::add);
    }

    private BigDecimal calculateExpenses() {
        return calculateCombinedExpenditure(
            stream(ExpenditureCategory.values())
                .filter(category -> !category.isCostOfSale())
                .collect(toList()));
    }

    private BigDecimal calculateCombinedExpenditure(List<ExpenditureCategory> categories) {
        return expenditureService.listByCategories(categories).stream()
            .map(Expenditure::getAmount)
            .reduce(ZERO, BigDecimal::add);
    }

    private BigDecimal calculateCorporationTax(BigDecimal profitBeforeTax) {
        return profitBeforeTax.multiply(CORPORATION_TAX_RATE).setScale(2, HALF_UP);
    }
}
