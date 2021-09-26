package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.exception.SalesmanDeleteNotAllowedException;
import com.gdi.posbackend.exception.SalesmanNotFoundException;
import com.gdi.posbackend.mapper.SalesmanMapper;
import com.gdi.posbackend.model.criteria.SalesmanCriteria;
import com.gdi.posbackend.model.request.CreateSalesmanRequest;
import com.gdi.posbackend.model.request.UpdateSalesmanRequest;
import com.gdi.posbackend.model.response.SalesmanResponse;
import com.gdi.posbackend.repository.SalesmanRepository;
import com.gdi.posbackend.service.CompanyService;
import com.gdi.posbackend.service.SaleOrderService;
import com.gdi.posbackend.service.SaleService;
import com.gdi.posbackend.service.SalesmanService;
import com.gdi.posbackend.specification.SalesmanSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.gdi.posbackend.specification.SalesmanSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:25 AM
 */
@Service
@AllArgsConstructor
public class SalesmanServiceImpl implements SalesmanService {

    private final SalesmanRepository salesmanRepository;
    private final SalesmanMapper salesmanMapper;
    private final CompanyService companyService;
    private final SaleOrderService saleOrderService;
    private final SaleService saleService;

    @Override
    public Salesman findSalesmanByIdOrThrowNotFound(String salesmanId) {
        return salesmanRepository.findById(salesmanId)
                .orElseThrow(() -> new SalesmanNotFoundException("salesman with id " + salesmanId + " not found"));
    }

    @Override
    public Page<SalesmanResponse> getSalesmen(SalesmanCriteria salesmanCriteria, Pageable pageable) {
        Specification<Salesman> specification = where(null);

        if (salesmanCriteria.getName() != null)
            specification = specification.or(nameIsLike(salesmanCriteria.getName()));

        if (salesmanCriteria.getAddress() != null)
            specification = specification.or(addressIsLike(salesmanCriteria.getAddress()));

        if (salesmanCriteria.getPhone() != null)
            specification = specification.or(phoneIsLike(salesmanCriteria.getPhone()));

        if (salesmanCriteria.getCompanyName() != null)
            specification = specification.or(companyNameIsLike(salesmanCriteria.getCompanyName()));

        return salesmanRepository.findAll(specification, pageable).map(salesmanMapper::mapSalesmanToSalesmanResponse);
    }

    @Override
    public SalesmanResponse createSalesman(CreateSalesmanRequest createSalesmanRequest) {
        Salesman salesman = new Salesman();
        salesman.setName(createSalesmanRequest.getName());
        salesman.setAddress(createSalesmanRequest.getAddress());
        salesman.setPhone(createSalesmanRequest.getPhone());
        salesman.setNationalIdentificationNumber(createSalesmanRequest.getNationalIdentificationNumber());
        salesman.setCompany(companyService.findCompanyByIdOrThrowNotFound(createSalesmanRequest.getCompanyId()));

        salesman = salesmanRepository.save(salesman);

        return salesmanMapper.mapSalesmanToSalesmanResponse(salesman);
    }

    @Override
    public SalesmanResponse getSalesman(String salesmanId) {
        return salesmanMapper.mapSalesmanToSalesmanResponse(findSalesmanByIdOrThrowNotFound(salesmanId));
    }

    @Override
    public SalesmanResponse updateSalesman(String salesmanId, UpdateSalesmanRequest updateSalesmanRequest) {
        Salesman salesman = findSalesmanByIdOrThrowNotFound(salesmanId);

        if (updateSalesmanRequest.getName() != null)
            salesman.setName(updateSalesmanRequest.getName());

        if (updateSalesmanRequest.getAddress() != null)
            salesman.setAddress(updateSalesmanRequest.getAddress());

        if (updateSalesmanRequest.getPhone() != null)
            salesman.setPhone(updateSalesmanRequest.getPhone());

        if (updateSalesmanRequest.getCompanyId() != null)
            salesman.setCompany(companyService.findCompanyByIdOrThrowNotFound(updateSalesmanRequest.getCompanyId()));

        salesmanRepository.save(salesman);

        return salesmanMapper.mapSalesmanToSalesmanResponse(salesman);
    }

    @Override
    public String deleteSalesman(String salesmanId) {
        Salesman salesman = findSalesmanByIdOrThrowNotFound(salesmanId);

        if (saleOrderService.saleOrderCountBySalesman(salesman) + saleService.saleCountBySalesman(salesman) > 0) {
            throw new SalesmanDeleteNotAllowedException("salesman delete not allowed");
        }

        salesmanRepository.delete(salesman);

        return salesmanId;
    }

    @Override
    public List<SalesmanResponse> getListSalesman() {
        return salesmanRepository
                .findAll()
                .stream()
                .map(salesmanMapper::mapSalesmanToSalesmanResponse)
                .collect(Collectors.toList());
    }
}
