package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.mapper.CompanyMapper;
import com.gdi.posbackend.mapper.EmployeeMapper;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.response.EmployeeResponse;
import com.gdi.posbackend.model.response.SimplifiedEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/13/2021 2:28 AM
 */
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .user(userMapper.mapUserToSimplifiedUserResponse(employee.getUser()))
                .company(companyMapper.mapCompanyToCompanyResponse(employee.getCompany()))
                .nationalIdentificationNumber(employee.getNationalIdentificationNumber())
                .placeOfBirth(employee.getPlaceOfBirth())
                .dateOfBirth(employee.getDateOfBirth())
                .address(employee.getAddress())
                .addressInIdentityCard(employee.getAddressInIdentityCard())
                .religion(employee.getReligion())
                .education(employee.getEducation())
                .joinDate(employee.getJoinDate())
                .phone(employee.getPhone())
                .phone2(employee.getPhone2())
                .email(employee.getEmail())
                .officeEmail(employee.getOfficeEmail())
                .marriage(employee.getMarriage())
                .gender(employee.getGender())
                .taxIdentificationNumber(employee.getTaxIdentificationNumber())
                .insuranceAndSocialSecurity(employee.getInsuranceAndSocialSecurity())
                .bankName(employee.getBankName())
                .bankBranch(employee.getBankBranch())
                .bankAccountNumber(employee.getBankAccountNumber())
                .status(employee.getStatus())
                .active(employee.getActive())
                .build();
    }

    @Override
    public SimplifiedEmployeeResponse mapEmployeeToSimplifiedEmployeeResponse(Employee employee) {
        return SimplifiedEmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .nationalIdentificationNumber(employee.getNationalIdentificationNumber())
                .placeOfBirth(employee.getPlaceOfBirth())
                .dateOfBirth(employee.getDateOfBirth())
                .address(employee.getAddress())
                .addressInIdentityCard(employee.getAddressInIdentityCard())
                .religion(employee.getReligion())
                .education(employee.getEducation())
                .joinDate(employee.getJoinDate())
                .phone(employee.getPhone())
                .phone2(employee.getPhone2())
                .email(employee.getEmail())
                .officeEmail(employee.getOfficeEmail())
                .marriage(employee.getMarriage())
                .gender(employee.getGender())
                .taxIdentificationNumber(employee.getTaxIdentificationNumber())
                .insuranceAndSocialSecurity(employee.getInsuranceAndSocialSecurity())
                .bankName(employee.getBankName())
                .bankBranch(employee.getBankBranch())
                .bankAccountNumber(employee.getBankAccountNumber())
                .status(employee.getStatus())
                .active(employee.getActive())
                .build();
    }
}
