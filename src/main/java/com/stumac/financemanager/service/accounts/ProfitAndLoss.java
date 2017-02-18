package com.stumac.financemanager.service.accounts;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

import static org.springframework.format.annotation.NumberFormat.Style.CURRENCY;

@Getter
@Builder
public class ProfitAndLoss
{

    /**
     * Also called sales, revenue or income. The total amount this period from selling goods or services, excluding VAT.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal turnover;

    /**
     * The costs directly involved in producing or delivering goods and services, for example, materials or shipping.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal costOfSales;

    /**
     * Turnover minus cost of sales.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal grossProfit;

    /**
     * Costs like packaging, transporting or storing the goods or services sold.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal distributionCosts;

    /**
     * The costs of managing and running the business, for example rent, utilities, print, stationary, legal and accounting fees.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal administrativeExpenses;

    /**
     * Income from other trading activities, for example, subletting a property, or selling goods as a sideline to your main business.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal otherOperatingIncome;

    /**
     * Gross profit or (loss) minus distribution costs and administrative expenses, plus other operating income.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal operatingProfit;

    /**
     * Interest earned or owed to the company, for example bank interest or interest from loans.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal interestReceivable;

    /**
     * Interest paid by the company, for example on loans or overdrafts.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal interestPayable;

    /**
     * Operating profit or (loss) plus interest receivable and similar income, minus interest payable and similar charges.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal profitBeforeTax;

    /**
     * Your taxable income is profit or (loss) before tax minus any reliefs due.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal taxOnProfit;

    /**
     * Profit or (loss) before tax minus tax on profit.
     */
    @NumberFormat(style = CURRENCY)
    private BigDecimal profit;
}
