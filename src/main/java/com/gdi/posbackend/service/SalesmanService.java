package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.model.criteria.SalesmanCriteria;
import com.gdi.posbackend.model.request.CreateSalesmanRequest;
import com.gdi.posbackend.model.request.UpdateSalesmanRequest;
import com.gdi.posbackend.model.response.SalesmanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:25 AM
 */
public interface SalesmanService {
    Salesman findSalesmanByIdOrThrowNotFound(String salesmanId);

    Page<SalesmanResponse> getSalesmen(SalesmanCriteria salesmanCriteria, Pageable pageable);

    SalesmanResponse createSalesman(CreateSalesmanRequest createSalesmanRequest);

    SalesmanResponse getSalesman(String salesmanId);

    SalesmanResponse updateSalesman(String salesmanId, UpdateSalesmanRequest updateSalesmanRequest);

    String deleteSalesman(String salesmanId);

    List<SalesmanResponse> getListSalesman();
}
