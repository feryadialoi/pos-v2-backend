package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchaseorder.CreatePurchaseOrderCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.exception.*;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.commandparam.CreatePurchaseOrderCommandParam;
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

        PurchaseOrderStatus status = purchaseOrderCriteria.getStatus();
        String supplierName = purchaseOrderCriteria.getSupplierName();
        String code = purchaseOrderCriteria.getCode();
        String startDate = purchaseOrderCriteria.getStartDate();
        String endDate = purchaseOrderCriteria.getEndDate();
        List<PurchaseOrderStatus> statuses = purchaseOrderCriteria.getStatuses();

        log.info(purchaseOrderCriteria.toString());

        Specification<PurchaseOrder> specification = Specification.where(null);

        if (status != null) specification = specification.and(statusIs(status));

        if (statuses != null) specification = specification.and(statusesIn(statuses));

        if (supplierName != null) specification = specification.and(supplierNameIsLike(supplierName));

        if (code != null) specification = specification.and(codeIsLike(code));

        if (startDate != null) specification = specification.and(startDateGreaterThanOrEqual(startDate));

        if (endDate != null) specification = specification.and(endDateLessThanOrEqual(endDate));

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
    public PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId) {
        return purchaseOrderRepository
                .findById(purchaseOrderId)
                .orElseThrow(() -> new PurchaseOrderNotFoundException("purchase order with id " + purchaseOrderId + " not found"));
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

        PurchaseOrder purchaseOrder = findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);
        PurchaseOrderStatus status = updatePurchaseOrderStatusRequest.getStatus();

        if (status == PurchaseOrderStatus.APPROVED) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is " + purchaseOrder.getStatus());
            }
        } else if (status == PurchaseOrderStatus.AWAITING_APPROVAL) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case REFUSED:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is " + purchaseOrder.getStatus());
            }
        } else if (status == PurchaseOrderStatus.REFUSED) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is " + purchaseOrder.getStatus());
            }
        } else {
            throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
        }

        purchaseOrder.setStatus(status);

        purchaseOrderRepository.save(purchaseOrder);

        return purchaseOrderMapper.mapPurchaseOrderToUpdatePurchaseOrderStatusResponse(purchaseOrder);
    }

}