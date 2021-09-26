package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.model.criteria.SaleCriteria;
import com.gdi.posbackend.model.request.CreateSaleRequest;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:45 PM
 */
public interface SaleService {
    Page<SaleResponse> getSales(SaleCriteria saleCriteria, Pageable pageable);

    DetailedSaleResponse getSale(String saleId);

    DetailedSaleResponse createSale(CreateSaleRequest createSaleRequest);

    Long saleCountByCustomer(Customer customer);

    Long saleCountBySalesman(Salesman salesman);
}
