package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Feryadialoi
 * @date 9/14/2021 2:40 PM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaleOrderRepositoryTest {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Test
    void test() {
        Customer customer = new Customer();
        customer.setId("072c332d-8e73-4a21-b3c1-9c284489d325");
        long count = saleOrderRepository.countByCustomer(customer);
        Assertions.assertTrue(count > 0);
    }
}
