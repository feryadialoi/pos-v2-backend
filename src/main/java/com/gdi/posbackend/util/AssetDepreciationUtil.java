package com.gdi.posbackend.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/20/2021 3:13 AM
 */
@Component
public class AssetDepreciationUtil {
    BigDecimal straightLine() {
        return BigDecimal.ZERO;
    }

    BigDecimal doubleDecliningBalance() {
        return BigDecimal.ZERO;
    }

    BigDecimal sumOfTheYearDigit() {
        return BigDecimal.ZERO;
    }
}
