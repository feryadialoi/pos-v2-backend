package com.gdi.posbackend.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/3/2021 11:38 AM
 */
@SpringBootTest
class ValueAddedTaxUtilTest {

    @Autowired
    private ValueAddedTaxUtil valueAddedTaxUtil;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1() {
        BigDecimal amount = BigDecimal.valueOf(500_000);
        Boolean isTaxed = false;

        Assertions.assertEquals(
                BigDecimal.valueOf(500_000), // expected
                valueAddedTaxUtil.getAmountExcludeTax(amount, isTaxed) // actual
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(550_000), // expected
                valueAddedTaxUtil.getAmountIncludeTax(amount, isTaxed) // actual
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(50_000), // expected
                valueAddedTaxUtil.getTax(amount, isTaxed) // actual
        );
    }

    @Test
    void test2() {
        BigDecimal amount = BigDecimal.valueOf(550_000);
        Boolean isTaxed = true;

        Assertions.assertEquals(
                BigDecimal.valueOf(500_000), // expected
                valueAddedTaxUtil.getAmountExcludeTax(amount, isTaxed) // actual
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(550_000), // expected
                valueAddedTaxUtil.getAmountIncludeTax(amount, isTaxed) // actual
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(50_000), // expected
                valueAddedTaxUtil.getTax(amount, isTaxed) // actual
        );
    }
}