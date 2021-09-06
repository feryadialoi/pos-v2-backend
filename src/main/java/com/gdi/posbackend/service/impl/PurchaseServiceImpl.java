package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchase.CreatePurchaseCommand;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.exception.PurchaseNotFoundException;
import com.gdi.posbackend.mapper.PurchaseMapper;
import com.gdi.posbackend.model.commandparam.CreatePurchaseCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;
import com.gdi.posbackend.repository.PurchaseRepository;
import com.gdi.posbackend.service.PurchaseService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.PurchaseSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:45 AM
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    // ** repository
    private final PurchaseRepository purchaseRepository;

    // ** service executor
    private final ServiceExecutor serviceExecutor;

    // ** mapper
    private final PurchaseMapper purchaseMapper;

    @Override
    public Page<PurchaseResponse> getPurchases(PurchaseCriteria purchaseCriteria, Pageable pageable) {

        String code = purchaseCriteria.getCode();
        String supplierName = purchaseCriteria.getSupplierName();
        String startDate = purchaseCriteria.getStartDate();
        String endDate = purchaseCriteria.getEndDate();
        PurchaseStatus status = purchaseCriteria.getStatus();

        log.info(purchaseCriteria.toString());

        Specification<Purchase> specification = where(null);

        if (code != null) specification = specification.and(codeIsLike(code));

        if (supplierName != null) specification = specification.and(supplierNameIsLike(supplierName));

        if (startDate != null) specification = specification.and(startDateGreaterThanOrEqual(startDate));

        if (endDate != null) specification = specification.and(endDateLessThanOrEqual(endDate));

        if (status != null) specification = specification.and(statusIs(status));

        return purchaseRepository.findAll(specification, pageable).map(purchaseMapper::mapPurchaseToPurchaseResponse);

    }

    @Override
    public DetailedPurchaseResponse getPurchase(String purchaseId) {
        return purchaseRepository.findById(purchaseId)
                .map(purchaseMapper::mapPurchaseToDetailedPurchaseResponse)
                .orElseThrow(() -> new PurchaseNotFoundException("purchase with id " + purchaseId + " not found"));
    }

    @Override
    public DetailedPurchaseResponse createPurchase(CreatePurchaseRequest createPurchaseRequest) {
        return serviceExecutor.execute(CreatePurchaseCommand.class, new CreatePurchaseCommandParam(createPurchaseRequest));
    }

}
