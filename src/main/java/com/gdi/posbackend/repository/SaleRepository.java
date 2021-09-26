package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.exception.SaleNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:22 AM
 */
public interface SaleRepository extends JpaRepository<Sale, String>, JpaSpecificationExecutor<Sale> {
    long countByCustomer(Customer customer);

    long countBySalesman(Salesman salesman);

    boolean existsBySaleOrder(SaleOrder saleOrder);

    default Sale findByIdOrThrowNotFound(String saleId) {
        return findById(saleId).orElseThrow(() -> new SaleNotFoundException("sale with id " + saleId + " not found"));
    }
}
