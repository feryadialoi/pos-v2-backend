package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.saleorder.CreateSaleOrderCommand;
import com.gdi.posbackend.command.saleorder.GetSaleOrderCommand;
import com.gdi.posbackend.command.saleorder.GetSaleOrdersCommand;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import com.gdi.posbackend.model.commandparam.CreateSaleOrderCommandParam;
import com.gdi.posbackend.model.commandparam.GetSaleOrderCommandParam;
import com.gdi.posbackend.model.commandparam.GetSaleOrdersCommandParam;
import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import com.gdi.posbackend.service.SaleOrderService;
import com.gdi.posbackend.service.ServiceExecutor;
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

    // ** repository
    private final SaleOrderRepository saleOrderRepository;

    // ** service
    private final ServiceExecutor serviceExecutor;


    @Override
    public Page<SaleOrderResponse> getSaleOrders(SaleOrderCriteria saleOrderCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetSaleOrdersCommand.class, new GetSaleOrdersCommandParam(saleOrderCriteria, pageable));
    }

    @Override
    public DetailedSaleOrderResponse getSaleOrder(String saleOrderId) {
        return serviceExecutor.execute(GetSaleOrderCommand.class, new GetSaleOrderCommandParam(saleOrderId));
    }

    @Override
    public DetailedSaleOrderResponse createSaleOrder(CreateSaleOrderRequest createSaleOrderRequest) {
        return serviceExecutor.execute(CreateSaleOrderCommand.class, new CreateSaleOrderCommandParam(createSaleOrderRequest));
    }

    @Override
    public SaleOrder findSaleOrderByIdOrThrowNotFound(String saleOrderId) {
        return saleOrderRepository.findById(saleOrderId)
                .orElseThrow(() -> new SaleOrderNotFoundException("sale order with id " + saleOrderId + " not found"));
    }
}
