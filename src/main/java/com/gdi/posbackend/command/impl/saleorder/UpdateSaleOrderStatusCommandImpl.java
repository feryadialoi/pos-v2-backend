package com.gdi.posbackend.command.impl.saleorder;

import com.gdi.posbackend.command.saleorder.UpdateSaleOrderStatusCommand;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import com.gdi.posbackend.exception.UpdateSaleOrderStatusNotAllowedException;
import com.gdi.posbackend.mapper.SaleOrderMapper;
import com.gdi.posbackend.model.commandparam.UpdateSaleOrderStatusCommandParam;
import com.gdi.posbackend.model.request.UpdateSaleOrderStatusRequest;
import com.gdi.posbackend.model.response.UpdateSaleOrderStatusResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/16/2021 1:25 PM
 */
@Component
@AllArgsConstructor
public class UpdateSaleOrderStatusCommandImpl implements UpdateSaleOrderStatusCommand {

    private final SaleOrderRepository saleOrderRepository;
    private final SaleOrderMapper saleOrderMapper;

    @Override
    public UpdateSaleOrderStatusResponse execute(UpdateSaleOrderStatusCommandParam updateSaleOrderStatusCommandParam) {

        String saleOrderId = updateSaleOrderStatusCommandParam.getSaleOrderId();
        UpdateSaleOrderStatusRequest updateSaleOrderStatusRequest = updateSaleOrderStatusCommandParam.getUpdateSaleOrderStatusRequest();

        SaleOrder saleOrder = saleOrderRepository.findByIdOrThrowNotFound(saleOrderId);

        switch (updateSaleOrderStatusRequest.getStatus()) {
            case DRAFT -> handleUpdateStatusToDraft(saleOrder, updateSaleOrderStatusRequest.getStatus());
            case SENT -> handleUpdateStatusToSent(saleOrder, updateSaleOrderStatusRequest.getStatus());
            case ACCEPTED -> handleUpdateStatusToAccepted(saleOrder, updateSaleOrderStatusRequest.getStatus());
            case DECLINED -> handleUpdateStatusToDeclined(saleOrder, updateSaleOrderStatusRequest.getStatus());
            case VOID -> handleUpdateStatusToVoid(saleOrder, updateSaleOrderStatusRequest.getStatus());
        }

        return saleOrderMapper.mapSaleOrderToUpdateSaleOrderStatusResponse(saleOrder);
    }

    private void handleUpdateStatusToDraft(SaleOrder saleOrder, SaleOrderStatus status) {
        throw new UpdateSaleOrderStatusNotAllowedException("update sale order status to " + status + " not allowed");
    }

    private void handleUpdateStatusToSent(SaleOrder saleOrder, SaleOrderStatus status) {
        if (saleOrder.getStatus() != SaleOrderStatus.DRAFT) {
            throw new UpdateSaleOrderStatusNotAllowedException("update sale order status to " + status + " not allowed");
        }

        saleOrder.setStatus(status);

        saleOrderRepository.save(saleOrder);
    }

    private void handleUpdateStatusToAccepted(SaleOrder saleOrder, SaleOrderStatus status) {
        if (saleOrder.getStatus() != SaleOrderStatus.SENT) {
            throw new UpdateSaleOrderStatusNotAllowedException("update sale order status to " + status + " not allowed");
        }

        saleOrder.setStatus(status);

        saleOrderRepository.save(saleOrder);
    }

    private void handleUpdateStatusToDeclined(SaleOrder saleOrder, SaleOrderStatus status) {
        if (saleOrder.getStatus() != SaleOrderStatus.SENT) {
            throw new UpdateSaleOrderStatusNotAllowedException("update sale order status to " + status + " not allowed");
        }

        saleOrder.setStatus(status);

        saleOrderRepository.save(saleOrder);
    }

    private void handleUpdateStatusToVoid(SaleOrder saleOrder, SaleOrderStatus status) {
        throw new UpdateSaleOrderStatusNotAllowedException("update sale order status to " + status + " not allowed");
    }

}
