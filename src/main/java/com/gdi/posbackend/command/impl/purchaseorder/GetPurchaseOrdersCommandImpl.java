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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Pageable pageable = getPurchaseOrdersCommandParam.getPageable();

        Specification<PurchaseOrder> specification = Specification.where(null);

        if (purchaseOrderCriteria.getStatus() != null)
            specification = specification.and(statusIs(purchaseOrderCriteria.getStatus()));

        if (purchaseOrderCriteria.getStatuses() != null)
            specification = specification.and(statusesIn(purchaseOrderCriteria.getStatuses()));

        if (purchaseOrderCriteria.getSupplierName() != null)
            specification = specification.and(supplierNameIsLike(purchaseOrderCriteria.getSupplierName()));

        if (purchaseOrderCriteria.getCode() != null)
            specification = specification.and(codeIsLike(purchaseOrderCriteria.getCode()));

        if (purchaseOrderCriteria.getStartDate() != null)
            specification = specification.and(startDateGreaterThanOrEqual(purchaseOrderCriteria.getStartDate()));

        if (purchaseOrderCriteria.getEndDate() != null)
            specification = specification.and(endDateLessThanOrEqual(purchaseOrderCriteria.getEndDate()));

        return purchaseOrderRepository.findAll(specification, pageable).map(purchaseOrderMapper::mapPurchaseOrderToPurchaseOrderResponse);

    }
}
