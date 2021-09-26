package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.exception.CompanyNotFoundException;
import com.gdi.posbackend.mapper.CompanyMapper;
import com.gdi.posbackend.model.criteria.CompanyCriteria;
import com.gdi.posbackend.model.request.CreateCompanyRequest;
import com.gdi.posbackend.model.response.CompanyResponse;
import com.gdi.posbackend.model.response.CompanyWithEmployeesResponse;
import com.gdi.posbackend.model.response.CompanyWithUsersResponse;
import com.gdi.posbackend.repository.CompanyRepository;
import com.gdi.posbackend.service.CompanyService;
import com.gdi.posbackend.specification.CompanySpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:00 PM
 */
@Service
@Transactional
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    // ** repository
    private final CompanyRepository companyRepository;

    // ** mapper
    private final CompanyMapper companyMapper;


    @Override
    public Page<CompanyResponse> getCompanies(CompanyCriteria companyCriteria, Pageable pageable) {

        Specification<Company> specification = Specification.where(null);

        if (companyCriteria.getName() != null) {
            specification = specification.and(CompanySpecification.nameIsLike(companyCriteria.getName()));
        }

        Page<Company> page = companyRepository.findAll(specification, pageable);

        return page.map(companyMapper::mapCompanyToCompanyResponse);
    }

    @Override
    public CompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) {
        Company company = new Company();
        company.setName(createCompanyRequest.getName());
        company.setAddress(createCompanyRequest.getAddress());
        company.setPhone(createCompanyRequest.getPhone());
        company.setBankName(createCompanyRequest.getBankName());
        company.setBankBranch(createCompanyRequest.getBankBranch());
        company.setBankAccountNumber(createCompanyRequest.getBankAccountNumber());
        company.setTaxableFirmName(createCompanyRequest.getTaxableFirmName());
        company.setTaxableFirmAddress(createCompanyRequest.getTaxableFirmAddress());
        company.setTaxIdentificationNumber(createCompanyRequest.getTaxIdentificationNumber());

        company = companyRepository.save(company);

        return companyMapper.mapCompanyToCompanyResponse(company);

    }

    @Override
    public CompanyResponse getCompany(String companyId) {
        return companyRepository.findById(companyId)
                .map(companyMapper::mapCompanyToCompanyResponse)
                .orElseThrow(() -> new CompanyNotFoundException("company with id " + companyId + " not found"));
    }

    @Override
    public Company findCompanyByIdOrThrowNotFound(String companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("company with id " + companyId + " not found"));
    }

    @Override
    public CompanyWithUsersResponse getCompanyWithUsers(String companyId) {
        return companyMapper.mapCompanyToCompanyWithUsersResponse(findCompanyByIdOrThrowNotFound(companyId));
    }

    @Override
    public CompanyWithEmployeesResponse getCompanyWithEmployees(String companyId) {
        return companyMapper.mapCompanyToCompanyWithEmployeesResponse(findCompanyByIdOrThrowNotFound(companyId));
    }
}
