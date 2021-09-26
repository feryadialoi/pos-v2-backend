package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:36 PM
 */
public interface SaleOrderRepository extends JpaRepository<SaleOrder, String>, JpaSpecificationExecutor<SaleOrder> {
    long countByCustomer(Customer customer);

    long countBySalesman(Salesman salesman);

    default SaleOrder findByIdOrThrowNotFound(String saleOrderId) {
        return findById(saleOrderId).orElseThrow(() -> new SaleOrderNotFoundException("sale order with id " + saleOrderId + " not found"));
    }
}
