package com.gdi.posbackend.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/31/2021 3:18 PM
 */
@Component
public class NominalUtil {
    public Boolean isNominalNotZero(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
