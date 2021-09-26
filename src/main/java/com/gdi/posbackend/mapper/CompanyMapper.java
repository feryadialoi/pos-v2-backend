package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.model.response.CompanyResponse;
import com.gdi.posbackend.model.response.CompanyWithEmployeesResponse;
import com.gdi.posbackend.model.response.CompanyWithUsersResponse;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:22 AM
 */
public interface CompanyMapper {
    CompanyResponse mapCompanyToCompanyResponse(Company company);

    CompanyWithUsersResponse mapCompanyToCompanyWithUsersResponse(Company company);

    CompanyWithEmployeesResponse mapCompanyToCompanyWithEmployeesResponse(Company company);
}
