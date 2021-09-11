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
        String                           purchaseOrderId                  = updatePurchaseOrderStatusCommandParam.getPurchaseOrderId();
        UpdatePurchaseOrderStatusRequest updatePurchaseOrderStatusRequest = updatePurchaseOrderStatusCommandParam.getUpdatePurchaseOrderStatusRequest();
        PurchaseOrder                    purchaseOrder                    = purchaseOrderRepository.findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);
        PurchaseOrderStatus              status                           = updatePurchaseOrderStatusRequest.getStatus();

        if (status == PurchaseOrderStatus.APPROVED) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is "
                            + purchaseOrder.getStatus());
            }
        } else if (status == PurchaseOrderStatus.AWAITING_APPROVAL) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case REFUSED:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is "
                            + purchaseOrder.getStatus());
            }
        } else if (status == PurchaseOrderStatus.REFUSED) {
            switch (purchaseOrder.getStatus()) {
                case VOID:
                case COMPLETE:
                    throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to "
                            + status + " not allowed, purchase order status is "
                            + purchaseOrder.getStatus());
            }
        } else {
            throw new UpdatePurchaseOrderStatusNotAllowedException("update purchase order status to " + status + " not allowed");
        }

        purchaseOrder.setStatus(status);

        purchaseOrderRepository.save(purchaseOrder);

        return purchaseOrderMapper.mapPurchaseOrderToUpdatePurchaseOrderStatusResponse(purchaseOrder);

    }
}
