package com.gdi.posbackend;

import com.gdi.posbackend.constant.LocaleOptions;
import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.entity.enums.BalanceSheetFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author Feryadialoi
 * @date 7/24/2021 1:50 PM
 */
public class ETCTest {

    @Test
    void test() {
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
    }

    @Test
    void testRounding() {
        BigDecimal num1 = new BigDecimal("-1.123");
        BigDecimal num2 = new BigDecimal("1.127");

        BigDecimal bigDecimal1 = num1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal2 = num2.setScale(2, RoundingMode.HALF_UP);

        System.out.println(bigDecimal1.negate());
        System.out.println(bigDecimal2);
    }

    @Test
    void testBalanceSheetFormat() {
        BalanceSheetFormat balanceSheetFormat = BalanceSheetFormat.valueOf("STANDARD");
        System.out.println(balanceSheetFormat);
    }

    @Test
    void testLocale() {
        System.out.println(new Locale("in", "ID").equals(LocaleOptions.indonesia));
    }

    enum OrderStatus {
        PARTIALLY_SHIPPED;
    }

    @Test
    void testOrderStatus() {
        OrderStatus partially_shipped = OrderStatus.valueOf("PARTIALLY_SHIPPED");

        System.out.println(partially_shipped);

        OrderStatus orderStatus = OrderStatus.PARTIALLY_SHIPPED;
        System.out.println(orderStatus);
        System.out.println(orderStatus.name());

    }

    @Test
    void testLocalDateTime() {
        System.out.println(LocalDateTime.now());
    }

    @Test
    void testEntityConstructor() {
        Product product = new Product();
        Category category = new Category();
    }

    @Test
    void testCompletableFuture() throws InterruptedException, ExecutionException {
        System.out.println("before getString");
        getString();
        System.out.println("after getString");

    }

    Future<String> getString() throws InterruptedException {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                System.out.println("start async");
                Thread.sleep(2000);
                System.out.println("inside supply async");
                return "hello";
            }
        });
    }


}
