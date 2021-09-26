package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.mapper.CompanyMapper;
import com.gdi.posbackend.mapper.SalesmanMapper;
import com.gdi.posbackend.model.response.SalesmanResponse;
import com.gdi.posbackend.model.response.SimplifiedSalesmanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:10 PM
 */
@Component
public class SalesmanMapperImpl implements SalesmanMapper {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public SalesmanResponse mapSalesmanToSalesmanResponse(Salesman salesman) {
        return SalesmanResponse.builder()
                .id(salesman.getId())
                .name(salesman.getName())
                .address(salesman.getAddress())
                .phone(salesman.getPhone())
                .nationalIdentificationNumber(salesman.getNationalIdentificationNumber())
                .company(companyMapper.mapCompanyToCompanyResponse(salesman.getCompany()))
                .build();
    }

    @Override
    public SimplifiedSalesmanResponse mapSalesmanToSimplifiedSalesmanResponse(Salesman salesman) {
        return SimplifiedSalesmanResponse.builder()
                .id(salesman.getId())
                .name(salesman.getName())
                .address(salesman.getAddress())
                .phone(salesman.getPhone())
                .nationalIdentificationNumber(salesman.getNationalIdentificationNumber())
                .build();
    }

}
