package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.service.SaleOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/19/2021 12:55 AM
 */
@Service
@AllArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {

    @Override
    public Page<SaleOrderResponse> getSaleOrders(SaleOrderCriteria saleOrderCriteria, Pageable pageable) {
        return Page.empty();
    }

    @Override
    public DetailedSaleOrderResponse getSaleOrder(String saleOrderId) {
        return null;
    }

    @Override
    public DetailedSaleOrderResponse createSaleOrder(CreateSaleOrderRequest createSaleOrderRequest) {
        return null;
    }
}
