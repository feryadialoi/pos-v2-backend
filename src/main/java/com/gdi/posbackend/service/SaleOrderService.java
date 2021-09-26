package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import com.gdi.posbackend.model.request.UpdateSaleOrderStatusRequest;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.model.response.UpdateSaleOrderStatusResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:51 PM
 */
public interface SaleOrderService {
    Page<SaleOrderResponse> getSaleOrders(SaleOrderCriteria saleOrderCriteria, Pageable pageable);

    DetailedSaleOrderResponse getSaleOrder(String saleOrderId);

    DetailedSaleOrderResponse createSaleOrder(CreateSaleOrderRequest createSaleOrderRequest);

    SaleOrder findSaleOrderByIdOrThrowNotFound(String saleOrderId);

    Long saleOrderCountByCustomer(Customer customer);

    Long saleOrderCountBySalesman(Salesman salesman);

    UpdateSaleOrderStatusResponse updateSaleOrderStatus(String saleOrderId, UpdateSaleOrderStatusRequest updateSaleOrderStatusRequest);
}
