package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.ProductStockDetail_;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;

import static com.gdi.posbackend.specification.ProductStockDetailSpecification.productStockIdIs;
import static com.gdi.posbackend.specification.ProductStockDetailSpecification.quantityGreaterThan;

/**
 * @author Feryadialoi
 * @date 9/17/2021 11:47 AM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductStockDetailRepositoryTest {

    @Autowired
    private ProductStockDetailRepository productStockDetailRepository;


    @Test
    void testFindProductStockDetailByProductStockIdAndQuantityGreaterThanZeroOrderByCreatedAsc() {
        productStockDetailRepository.findAll(
                productStockIdIs("13cfeee9-c6ae-4cff-bb79-47ce6a88cced").and(quantityGreaterThan(BigDecimal.ZERO)),
                PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, ProductStockDetail_.CREATED_DATE))
        ).stream().findFirst().ifPresentOrElse(System.out::println, () -> {
            System.out.println("not found");
        });
    }

    @Test
    void testFindProductStockDetailByProductStockIdAndQuantityGreaterThanZeroOrderByCreatedDesc() {
        productStockDetailRepository.findAll(
                productStockIdIs("13cfeee9-c6ae-4cff-bb79-47ce6a88cced").and(quantityGreaterThan(BigDecimal.ZERO)),
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, ProductStockDetail_.CREATED_DATE))
        ).stream().findFirst().ifPresentOrElse(System.out::println, () -> {
            System.out.println("not found");
        });
    }

}
