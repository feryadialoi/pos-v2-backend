package com.gdi.posbackend.command.impl.sale;

import com.gdi.posbackend.command.sale.GetSalesCommand;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.mapper.SaleMapper;
import com.gdi.posbackend.model.commandparam.GetSalesCommandParam;
import com.gdi.posbackend.model.criteria.SaleCriteria;
import com.gdi.posbackend.model.response.SaleResponse;
import com.gdi.posbackend.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.SaleSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/15/2021 12:20 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class GetSalesCommandImpl implements GetSalesCommand {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Page<SaleResponse> execute(GetSalesCommandParam getSalesCommandParam) {
        SaleCriteria saleCriteria = getSalesCommandParam.getSaleCriteria();
        Pageable pageable = getSalesCommandParam.getPageable();

        Specification<Sale> specification = where(null);

        if (saleCriteria.getCode() != null) specification = specification.and(codeIsLike(saleCriteria.getCode()));

        if (saleCriteria.getCustomerName() != null) specification = specification.and(customerNameIsLike(saleCriteria.getCustomerName()));

        if (saleCriteria.getSalesmanName() != null) specification = specification.and(salesmanNameIsLike(saleCriteria.getSalesmanName()));

        if (saleCriteria.getStatus() != null) specification = specification.and(statusIs(saleCriteria.getStatus()));

        if (saleCriteria.getStartDate() != null) specification = specification.and(startDateGreaterThanOrEqual(saleCriteria.getStartDate()));

        if (saleCriteria.getEndDate() != null) specification = specification.and(endDateLessThanOrEqual(saleCriteria.getEndDate()));

        return saleRepository.findAll(specification, pageable).map(saleMapper::mapSaleToSaleResponse);
    }
}
