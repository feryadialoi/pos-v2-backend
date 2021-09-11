package com.gdi.posbackend.command.impl.purchaseorder;

import com.gdi.posbackend.command.purchaseorder.GetPurchaseOrdersCommand;
import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.commandparam.GetPurchaseOrdersCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import com.gdi.posbackend.repository.PurchaseOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gdi.posbackend.specification.PurchaseOrderSpecification.*;
import static com.gdi.posbackend.specification.PurchaseOrderSpecification.endDateLessThanOrEqual;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:27 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class GetPurchaseOrdersCommandImpl implements GetPurchaseOrdersCommand {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public Page<PurchaseOrderResponse> execute(GetPurchaseOrdersCommandParam getPurchaseOrdersCommandParam) {
        PurchaseOrderCriteria purchaseOrderCriteria = getPurchaseOrdersCommandParam.getPurchaseOrderCriteria();
        Pageable              pageable              = getPurchaseOrdersCommandParam.getPageable();

        PurchaseOrderStatus       status       = purchaseOrderCriteria.getStatus();
        String                    supplierName = purchaseOrderCriteria.getSupplierName();
        String                    code         = purchaseOrderCriteria.getCode();
        String                    startDate    = purchaseOrderCriteria.getStartDate();
        String                    endDate      = purchaseOrderCriteria.getEndDate();
        List<PurchaseOrderStatus> statuses     = purchaseOrderCriteria.getStatuses();

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
}
