package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.model.criteria.SaleCriteria;
import com.gdi.posbackend.model.request.CreateSaleRequest;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import com.gdi.posbackend.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:47 PM
 */
@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    @Override
    public Page<SaleResponse> getSales(SaleCriteria saleCriteria, Pageable pageable) {
        return Page.empty();
    }

    @Override
    public DetailedSaleResponse getSale(String saleId) {
        return null;
    }

    @Override
    public DetailedSaleResponse createSale(CreateSaleRequest createSaleRequest) {
        return null;
    }
}
