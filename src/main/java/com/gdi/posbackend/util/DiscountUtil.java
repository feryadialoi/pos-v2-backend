package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:47 AM
 */
@Component
public class DiscountUtil {

    private final BigDecimal PERCENT = BigDecimal.valueOf(100);

    public BigDecimal calculateDiscount(BigDecimal amount, DiscountFormat discountFormat, BigDecimal discount) {
        if (discountFormat == DiscountFormat.AMOUNT) {
            return discount;
        } else if (discountFormat == DiscountFormat.PERCENT) {
            return amount.multiply(discount).divide(PERCENT, RoundingMode.HALF_UP);
        } else {
            throw new RuntimeException("not supported format");
        }
    }

    public Boolean getIsDiscounted(BigDecimal discount) {
        return discount.compareTo(BigDecimal.ZERO) > 0;
    }

}