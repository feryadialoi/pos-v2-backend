package com.gdi.posbackend;

import com.gdi.posbackend.constant.LocaleOptions;
import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.entity.enums.BalanceSheetFormat;
import lombok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
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


    @Test
    void testMap() {
        List<String> data = List.of("name", "email", "name");

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {
            if (map.get(data.get(i)) != null) {
                System.out.println("found " + map.get(data.get(i)));
                String value = map.get(data.get(i));
                map.put(data.get(i), "'" + value + ", " + i + "'");
            } else {
                map.put(data.get(i), "'" + i + "'");
            }
        }

        System.out.println(map);

    }


    @Test
    void testRestParam() {
        restParam("Hello", "World", "!");
        restParam2(new Person("Diana"), new Person("Mario"), new Person("Mikaela"));
    }

    void restParam(String... value) {
        for (String s : value) {
            System.out.println(s);
        }
    }

    void restParam2(Person... people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    @Value
    static class Person {
        String name;

    }

    void testParam3(String value, Person... people) {
        System.out.println(value);
        StringBuilder name = new StringBuilder();
        for (Person person : people) {
            name.append(person.getName()).append(", ");
        }
        System.out.println(name);
    }

    @Test
    void testParam3() {
        testParam3("Hello", new Person("Diana"), new Person("Mario"));
    }
}