package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchaseorder.CreatePurchaseOrderCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.exception.PurchaseOrderNotFoundException;
import com.gdi.posbackend.exception.SupplierNotFoundException;
import com.gdi.posbackend.exception.UnitNotFoundException;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.PurchaseOrderCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreatePurchaseOrderCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.request.ApprovePurchaseOrderRequest;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.request.ProductOfCreatePurchaseOrderRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.PurchaseOrderRepository;
import com.gdi.posbackend.repository.SupplierRepository;
import com.gdi.posbackend.repository.UnitRepository;
import com.gdi.posbackend.service.PurchaseOrderService;
import com.gdi.posbackend.service.RunningNumberService;
import com.gdi.posbackend.service.ServiceExecutor;
import com.gdi.posbackend.specification.PurchaseOrderSpecification;
import com.gdi.posbackend.util.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/19/2021 12:54 AM
 */
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

        Specification<PurchaseOrder> specification = Specification.where(null);
        if (purchaseOrderCriteria.getStatus() != null)
            specification = specification.and(PurchaseOrderSpecification.statusIs(purchaseOrderCriteria.getStatus()));

        if (purchaseOrderCriteria.getSupplierName() != null)
            specification = specification.and(PurchaseOrderSpecification.supplierNameIsLike(purchaseOrderCriteria.getSupplierName()));

        if (purchaseOrderCriteria.getCode() != null)
            specification = specification.and(PurchaseOrderSpecification.codeIsLike(purchaseOrderCriteria.getCode()));

        if (purchaseOrderCriteria.getStartDate() != null)
            specification = specification.and(PurchaseOrderSpecification.startDateIs(purchaseOrderCriteria.getStartDate()));

        if (purchaseOrderCriteria.getEndDate() != null)
            specification = specification.and(PurchaseOrderSpecification.endDateIs(purchaseOrderCriteria.getEndDate()));

        return purchaseOrderRepository.findAll(specification, pageable).map(purchaseOrderMapper::mapPurchaseOrderToPurchaseOrderResponse);

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
    public Object approvePurchaseOrder(ApprovePurchaseOrderRequest approvePurchaseOrderRequest) {
        return purchaseOrderRepository.findById(approvePurchaseOrderRequest.getPurchaseOrderId()).map(purchaseOrder -> {
            purchaseOrder.setStatus(PurchaseOrderStatus.APPROVED);
            return purchaseOrder.getStatus();
        }).orElseThrow(() -> new PurchaseOrderNotFoundException("purchase order with id "
                + approvePurchaseOrderRequest.getPurchaseOrderId()
                + " not found")
        );
    }

    @Override
    public PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId) {
        return purchaseOrderRepository.findById(purchaseOrderId)
                .orElseThrow(() -> new PurchaseOrderNotFoundException("purchase order with id " + purchaseOrderId + " not found"));
    }


}
