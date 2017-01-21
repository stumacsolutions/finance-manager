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

    private static final BigDecimal FLAT_VAT_RATE = BigDecimal.valueOf(0.135);
    private static final BigDecimal VAT_RATE = BigDecimal.valueOf(0.20);

    private final ExpenditureService expenditureService;
    private final IncomeService incomeService;

    @Override
    public ProfitAndLoss generate() {
        BigDecimal sales = calculateSales();
        BigDecimal otherIncome = calculateOtherIncome();
        BigDecimal turnover = sales.add(otherIncome);
        BigDecimal costOfSales = calculateCostOfSales();
        BigDecimal grossProfit = turnover.subtract(costOfSales);
        BigDecimal expenses = calculateExpenses();
        BigDecimal netProfit = grossProfit.subtract(expenses);
        return ProfitAndLoss.builder()
            .sales(sales)
            .otherIncome(otherIncome)
            .turnover(turnover)
            .costOfSales(costOfSales)
            .grossProfit(grossProfit)
            .expenses(expenses)
            .netProfit(netProfit)
            .build();
    }

    private BigDecimal calculateSales() {
        return calculateCombinedIncome(singletonList(INVOICE))
            .divide(ONE.add(VAT_RATE), HALF_UP);
    }

    private BigDecimal calculateOtherIncome() {
        return calculateNonInvoiceIncome().add(calculateFlatRateProfit());
    }

    private BigDecimal calculateFlatRateProfit() {
        BigDecimal invoiceIncome = calculateCombinedIncome(singletonList(INVOICE));
        return invoiceIncome
            .subtract(invoiceIncome.multiply(FLAT_VAT_RATE))
            .subtract(calculateSales())
            .setScale(2, HALF_UP);
    }

    private BigDecimal calculateNonInvoiceIncome() {
        return calculateCombinedIncome(
            stream(IncomeSource.values())
                .filter(source -> source != INVOICE)
                .collect(toList()));
    }

    private BigDecimal calculateCombinedIncome(List<IncomeSource> sources) {
        return incomeService.listBySources(sources).stream()
            .map(Income::getAmount)
            .reduce(ZERO, BigDecimal::add);
    }

    private BigDecimal calculateCostOfSales() {
        return calculateCombinedExpenditure(
            stream(ExpenditureCategory.values())
                .filter(ExpenditureCategory::isCostOfSale)
                .collect(toList()));
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
}
