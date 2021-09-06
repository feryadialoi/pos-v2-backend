package com.gdi.posbackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * @author Feryadialoi
 * @date 9/4/2021 1:23 AM
 */
public class ObjectReferenceTest {
    @Test
    void test() {

        Product product = new Product(null, "product");
        Cart cart = new Cart(1, "cart", product);

        System.out.println(product);
        System.out.println(cart);

        System.out.println("=============================");

        product.setId(1);

        System.out.println(product);
        System.out.println(cart);


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Product {
        private Integer id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Cart {
        private Integer id;
        private String name;
        private Product product;
    }
}
