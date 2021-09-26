package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.mapper.CompanyMapper;
import com.gdi.posbackend.mapper.EmployeeMapper;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.response.CompanyResponse;
import com.gdi.posbackend.model.response.CompanyWithEmployeesResponse;
import com.gdi.posbackend.model.response.CompanyWithUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:22 AM
 */
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


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

    @Override
    public CompanyWithUsersResponse mapCompanyToCompanyWithUsersResponse(Company company) {
        return CompanyWithUsersResponse.builder()
                .company(mapCompanyToCompanyResponse(company))
                .users(company.getUsers().stream().map(userMapper::mapUserToSimplifiedUserResponse).collect(Collectors.toList()))
                .build();
    }

    @Override
    public CompanyWithEmployeesResponse mapCompanyToCompanyWithEmployeesResponse(Company company) {
        return CompanyWithEmployeesResponse.builder()
                .company(mapCompanyToCompanyResponse(company))
                .employees(company.getEmployees().stream().map(employeeMapper::mapEmployeeToSimplifiedEmployeeResponse).collect(Collectors.toList()))
                .build();
    }

}
