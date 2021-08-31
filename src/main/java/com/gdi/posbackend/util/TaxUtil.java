package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:47 AM
 */
@Component
public class TaxUtil {

    private final BigDecimal PERCENT = BigDecimal.valueOf(100);

    public BigDecimal calculateTax(BigDecimal amount, TaxFormat taxFormat, BigDecimal tax) {
        if (taxFormat == TaxFormat.AMOUNT) {
            return tax;
        } else if (taxFormat == TaxFormat.PERCENT) {
            return amount.multiply(tax).divide(PERCENT, RoundingMode.HALF_UP);
        } else {
            throw new RuntimeException("not supported format");
        }
    }

    public Boolean getIsTaxed(BigDecimal tax) {
        return tax.compareTo(BigDecimal.ZERO) > 0;
    }
}