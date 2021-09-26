package com.gdi.posbackend.command.impl.purchaseorder;

import com.gdi.posbackend.command.purchaseorder.UpdatePurchaseOrderStatusCommand;
import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.exception.UpdatePurchaseOrderStatusNotAllowedException;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.commandparam.UpdatePurchaseOrderStatusCommandParam;
import com.gdi.posbackend.model.request.UpdatePurchaseOrderStatusRequest;
import com.gdi.posbackend.model.response.UpdatePurchaseOrderStatusResponse;
import com.gdi.posbackend.repository.PurchaseOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:32 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class UpdatePurchaseOrderStatusCommandImpl implements UpdatePurchaseOrderStatusCommand {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;


    @Override
    public UpdatePurchaseOrderStatusResponse execute(UpdatePurchaseOrderStatusCommandParam updatePurchaseOrderStatusCommandParam) {
        String purchaseOrderId = updatePurchaseOrderStatusCommandParam.getPurchaseOrderId();
        UpdatePurchaseOrderStatusRequest updatePurchaseOrderStatusRequest = updatePurchaseOrderStatusCommandParam.getUpdatePurchaseOrderStatusRequest();

        PurchaseOrder purchaseOrder = purchaseOrderRepository.findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);

        switch (updatePurchaseOrderStatusRequest.getStatus()) {
            case DRAFT -> handleUpdateStatusToDraft(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
            case AWAITING_APPROVAL -> handleUpdateStatusToAwaitingApproval(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
            case APPROVED -> handleUpdateStatusToApproved(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
            case REFUSED -> handleUpdateStatusToRefused(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
            case COMPLETE -> handleUpdateStatusToComplete(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
            case VOID -> handleUpdateStatusToVoid(purchaseOrder, updatePurchaseOrderStatusRequest.getStatus());
        }

        return purchaseOrderMapper.mapPurchaseOrderToUpdatePurchaseOrderStatusResponse(purchaseOrder);
    }

    private void handleUpdateStatusToDraft(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
    }

    private void handleUpdateStatusToApproved(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        if (purchaseOrder.getStatus() != PurchaseOrderStatus.DRAFT || purchaseOrder.getStatus() != PurchaseOrderStatus.AWAITING_APPROVAL) {
            throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
        }

        purchaseOrder.setStatus(status);

        purchaseOrderRepository.save(purchaseOrder);
    }

    private void handleUpdateStatusToAwaitingApproval(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        if (purchaseOrder.getStatus() != PurchaseOrderStatus.DRAFT) {
            throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
        }

        purchaseOrder.setStatus(status);

        purchaseOrderRepository.save(purchaseOrder);
    }

    private void handleUpdateStatusToRefused(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        if (purchaseOrder.getStatus() != PurchaseOrderStatus.AWAITING_APPROVAL) {
            throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
        }

        purchaseOrder.setStatus(status);

        purchaseOrderRepository.save(purchaseOrder);
    }

    private void handleUpdateStatusToComplete(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
    }

    private void handleUpdateStatusToVoid(PurchaseOrder purchaseOrder, PurchaseOrderStatus status) {
        throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
    }

}
