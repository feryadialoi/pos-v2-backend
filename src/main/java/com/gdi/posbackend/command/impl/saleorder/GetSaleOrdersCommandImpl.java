package com.gdi.posbackend.command.impl.saleorder;

import com.gdi.posbackend.command.saleorder.GetSaleOrdersCommand;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.mapper.SaleOrderMapper;
import com.gdi.posbackend.model.commandparam.GetSaleOrdersCommandParam;
import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import com.gdi.posbackend.specification.SaleOrderSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.SaleOrderSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/7/2021 3:38 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class GetSaleOrdersCommandImpl implements GetSaleOrdersCommand {

    private final SaleOrderRepository saleOrderRepository;
    private final SaleOrderMapper saleOrderMapper;

    @Override
    public Page<SaleOrderResponse> execute(GetSaleOrdersCommandParam getSaleOrdersCommandParam) {

        SaleOrderCriteria saleOrderCriteria = getSaleOrdersCommandParam.getSaleOrderCriteria();
        Pageable pageable = getSaleOrdersCommandParam.getPageable();

        Specification<SaleOrder> specification = where(null);

        if (saleOrderCriteria.getCode() != null) specification = specification.and(codeIsLike(saleOrderCriteria.getCode()));

        if (saleOrderCriteria.getSalesmanName() != null) specification = specification.and(salesmanNameIsLike(saleOrderCriteria.getSalesmanName()));

        if (saleOrderCriteria.getCustomerName() != null) specification = specification.and(customerNameIsLike(saleOrderCriteria.getCustomerName()));

        if (saleOrderCriteria.getStatus() != null) specification = specification.and(statusIs(saleOrderCriteria.getStatus()));

        if (saleOrderCriteria.getStatuses() != null) specification = specification.and(statusesIn(saleOrderCriteria.getStatuses()));

        if (saleOrderCriteria.getStartDate() != null) specification = specification.and(startDateGreaterThanOrEqual(saleOrderCriteria.getStartDate()));

        if (saleOrderCriteria.getEndDate() != null) specification = specification.and(endDateLessThanOrEqual(saleOrderCriteria.getEndDate()));

        return saleOrderRepository.findAll(specification, pageable).map(saleOrderMapper::mapSaleOrderToSaleOrderResponse);
    }
}
