package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchase.CreatePurchaseCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.exception.*;
import com.gdi.posbackend.mapper.PurchaseMapper;
import com.gdi.posbackend.model.PurchaseCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreatePurchaseCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import com.gdi.posbackend.model.request.ProductOfCreatePurchaseRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;
import com.gdi.posbackend.repository.*;
import com.gdi.posbackend.service.*;
import com.gdi.posbackend.util.DiscountUtil;
import com.gdi.posbackend.util.LocalDateUtil;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import com.gdi.posbackend.util.TaxUtil;
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
 * @date 8/20/2021 1:45 AM
 */
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
        Specification<Purchase> specification = Specification.where(null);
        return purchaseRepository.findAll(specification, pageable)
                .map(purchaseMapper::mapPurchaseToPurchaseResponse);
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
