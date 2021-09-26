package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.model.criteria.CompanyCriteria;
import com.gdi.posbackend.model.request.CreateCompanyRequest;
import com.gdi.posbackend.model.response.CompanyResponse;
import com.gdi.posbackend.model.response.CompanyWithEmployeesResponse;
import com.gdi.posbackend.model.response.CompanyWithUsersResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:01 PM
 */
public interface CompanyService {

    Page<CompanyResponse> getCompanies(CompanyCriteria companyCriteria, Pageable pageable);

    CompanyResponse createCompany(CreateCompanyRequest createCompanyRequest);

    CompanyResponse getCompany(String companyId);

    Company findCompanyByIdOrThrowNotFound(String companyId);

    CompanyWithUsersResponse getCompanyWithUsers(String companyId);

    CompanyWithEmployeesResponse getCompanyWithEmployees(String companyId);
}
