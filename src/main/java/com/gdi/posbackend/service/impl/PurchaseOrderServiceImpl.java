package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchaseorder.CreatePurchaseOrderCommand;
import com.gdi.posbackend.command.purchaseorder.GetPurchaseOrdersCommand;
import com.gdi.posbackend.command.purchaseorder.UpdatePurchaseOrderStatusCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.exception.*;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.commandparam.CreatePurchaseOrderCommandParam;
import com.gdi.posbackend.model.commandparam.GetPurchaseOrdersCommandParam;
import com.gdi.posbackend.model.commandparam.UpdatePurchaseOrderStatusCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.request.UpdatePurchaseOrderStatusRequest;
import com.gdi.posbackend.model.response.*;
import com.gdi.posbackend.repository.PurchaseOrderRepository;
import com.gdi.posbackend.service.PurchaseOrderService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gdi.posbackend.specification.PurchaseOrderSpecification.*;

/**
 * @author Feryadialoi
 * @date 8/19/2021 12:54 AM
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    // ** repository
    private final PurchaseOrderRepository purchaseOrderRepository;

    // ** mapper
    private final PurchaseOrderMapper purchaseOrderMapper;

    // ** service executor
    private final ServiceExecutor serviceExecutor;


    @Override
    public Page<PurchaseOrderResponse> getPurchaseOrders(PurchaseOrderCriteria purchaseOrderCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetPurchaseOrdersCommand.class, new GetPurchaseOrdersCommandParam(purchaseOrderCriteria, pageable));
    }

    @Override
    public DetailedPurchaseOrderResponse getPurchaseOrder(String purchaseOrderId) {
        return purchaseOrderRepository.findById(purchaseOrderId)
                .map(purchaseOrderMapper::mapPurchaseOrderToDetailedPurchaseOrderResponse)
                .orElseThrow(() -> new PurchaseOrderNotFoundException("purchase order with id " + purchaseOrderId + " not found"));
    }

    @Override
    public DetailedPurchaseOrderResponse createPurchaseOrder(CreatePurchaseOrderRequest createPurchaseOrderRequest) {
        return serviceExecutor.execute(CreatePurchaseOrderCommand.class, new CreatePurchaseOrderCommandParam(createPurchaseOrderRequest));
    }

    @Override
    public PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId) {
        return purchaseOrderRepository.findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);
    }

    @Override
    public void completePurchaseOrderStatus(String purchaseOrderId) {
        PurchaseOrder purchaseOrder = findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);

        if (purchaseOrder.getStatus() == PurchaseOrderStatus.VOID) {
            throw new CompletePurchaseOrderNotAllowedException("purchase order status already " + purchaseOrder.getStatus() + ", complete not allowed");
        }

        if (purchaseOrder.getStatus() == PurchaseOrderStatus.REFUSED) {
            throw new CompletePurchaseOrderNotAllowedException("purchase order status already " + purchaseOrder.getStatus() + ", complete not allowed");
        }

        purchaseOrder.setStatus(PurchaseOrderStatus.COMPLETE);

        purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public UpdatePurchaseOrderStatusResponse updatePurchaseOrderStatus(String purchaseOrderId, UpdatePurchaseOrderStatusRequest updatePurchaseOrderStatusRequest) {
        return serviceExecutor.execute(UpdatePurchaseOrderStatusCommand.class, new UpdatePurchaseOrderStatusCommandParam(purchaseOrderId, updatePurchaseOrderStatusRequest));
    }

    @Override
    public Long purchaseOrderCountBySupplier(Supplier supplier) {
        return purchaseOrderRepository.countBySupplier(supplier);
    }

}