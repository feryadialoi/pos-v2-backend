package com.gdi.posbackend.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/3/2021 11:01 AM
 * <p>
 * Value Added Tax = PPN
 */
@Component
public class ValueAddedTaxUtil {

    private final BigDecimal TAX_PERCENT = BigDecimal.TEN;
    private final BigDecimal PERCENT = BigDecimal.valueOf(100);

    public BigDecimal getTax(BigDecimal amount, Boolean isTaxed) {
        /**
         * isTaxed true
         * example:
         * amount = 550.000
         * amountExcludeTax = 500.000
         * amountIncludeTax = 550.000
         * cal:
         * tax = 50.000
         * tax = 550.000 / 110 * 10
         *
         * -----------------------------
         * isTaxed false
         * example:
         * amount = 500.000
         * amountExcludeTax = 500.000
         * amountIncludeTax = 550.000
         * cal:
         * tax = 50.000
         * tax = 500.000 / 100 * 10
         */
        if (isTaxed) {
            return amount.divide(PERCENT.add(TAX_PERCENT)).multiply(TAX_PERCENT);
        } else {
            return amount.divide(PERCENT).multiply(TAX_PERCENT);
        }
    }

    public BigDecimal getAmountIncludeTax(BigDecimal amount, Boolean isTaxed) {
        if (isTaxed) {
            return amount;
        } else {
            return amount.add(getTax(amount, isTaxed));
        }
    }

    public BigDecimal getAmountExcludeTax(BigDecimal amount, Boolean isTaxed) {
        if (isTaxed) {
            return amount.subtract(getTax(amount, isTaxed));
        } else {
            return amount;
        }
    }
}