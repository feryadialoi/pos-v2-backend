package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.mapper.CompanyMapper;
import com.gdi.posbackend.model.response.CompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:22 AM
 */
@Component
@AllArgsConstructor
public class CompanyMapperImpl implements CompanyMapper {


    @Override
    public CompanyResponse mapCompanyToCompanyResponse(Company company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .phone(company.getPhone())
                .bankName(company.getBankName())
                .bankBranch(company.getBankBranch())
                .bankAccountNumber(company.getBankAccountNumber())
                .taxableFirmName(company.getTaxableFirmName())
                .taxableFirmAddress(company.getTaxableFirmAddress())
                .taxIdentificationNumber(company.getTaxIdentificationNumber())
                .build();
    }
}
