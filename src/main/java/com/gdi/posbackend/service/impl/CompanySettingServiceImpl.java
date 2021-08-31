package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.exception.CompanySettingNotFoundException;
import com.gdi.posbackend.mapper.CompanySettingMapper;
import com.gdi.posbackend.model.criteria.CompanySettingCriteria;
import com.gdi.posbackend.model.request.CreateCompanySettingRequest;
import com.gdi.posbackend.model.request.UpdateCompanyRequestWithChartOfAccountRequest;
import com.gdi.posbackend.model.request.UpdateCompanySettingRequest;
import com.gdi.posbackend.model.response.CompanySettingResponse;
import com.gdi.posbackend.model.response.CompanySettingWithChartOfAccountResponse;
import com.gdi.posbackend.repository.CompanySettingRepository;
import com.gdi.posbackend.service.CompanyService;
import com.gdi.posbackend.service.CompanySettingService;
import com.gdi.posbackend.specification.CompanySettingSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:05 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class CompanySettingServiceImpl implements CompanySettingService {

    // ** repository
    private final CompanySettingRepository companySettingRepository;

    // ** mapper
    private final CompanySettingMapper companySettingMapper;

    // ** service
    private final CompanyService companyService;

    @Override
    public List<CompanySettingResponse> getListCompanySetting(CompanySettingCriteria companySettingCriteria) {
        Specification<CompanySetting> specification = Specification.where(null);

        if (companySettingCriteria.getSettingName() != null)
            specification = specification.and(CompanySettingSpecification.settingNameIsLike(companySettingCriteria.getSettingName()));

        if (companySettingCriteria.getCategory() != null) {
            specification = specification.and(CompanySettingSpecification.categoryIs(companySettingCriteria.getCategory()));
        }

        return companySettingRepository.findAll(specification).stream()
                .map(companySettingMapper::mapCompanySettingToCompanySettingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CompanySettingResponse createCompanySetting(CreateCompanySettingRequest createCompanySettingRequest) {
        CompanySetting companySetting = new CompanySetting();

        companySetting.setCompany(companyService.findCompanyByIdOrThrowNotFound(createCompanySettingRequest.getCompanyId()));
        companySetting.setDisplayName(createCompanySettingRequest.getDisplayName());
        companySetting.setSettingName(createCompanySettingRequest.getSettingName());
        companySetting.setSettingValue(createCompanySettingRequest.getSettingValue());
        companySetting.setSettingValueType(createCompanySettingRequest.getSettingValueType());
        companySetting.setCategory(createCompanySettingRequest.getCategory());
        companySetting.setSettingDescription(createCompanySettingRequest.getSettingDescription());

        companySetting = companySettingRepository.save(companySetting);

        return companySettingMapper.mapCompanySettingToCompanySettingResponse(companySetting);
    }

    @Override
    public CompanySettingResponse updateCompanySetting(String companySettingId, UpdateCompanySettingRequest updateCompanySettingRequest) {
        return companySettingRepository.findById(companySettingId)
                .map(companySetting -> {
                    if (updateCompanySettingRequest.getSettingValue() != null) {
                        companySetting.setSettingValue(updateCompanySettingRequest.getSettingValue());
                    }
                    companySetting = companySettingRepository.save(companySetting);
                    return companySettingMapper.mapCompanySettingToCompanySettingResponse(companySetting);
                }).orElseThrow(() -> new CompanySettingNotFoundException("company setting not found"));
    }

    @Override
    public List<CompanySettingWithChartOfAccountResponse> getListCompanySettingChartOfAccount() {
        return companySettingRepository.findAllCompanySettingOfChartOfAccount().stream()
                .map(companySettingMapper::mapCompanySettingWithChartOfAccountToCompanySettingWithChartOfAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Long updateCompanySettingWithChartOfAccount(UpdateCompanyRequestWithChartOfAccountRequest updateCompanyRequestWithChartOfAccountRequest) {
        return updateCompanyRequestWithChartOfAccountRequest.getCompanySettings().stream()
                .map(companySetting -> companySettingRepository.updateSettingValueOfCompanySetting(
                        companySetting.getId(),
                        companySetting.getSettingValue()
                ))
                .filter(integer -> integer == 1)
                .count();
    }

    @Override
    public CompanySetting findCompanySettingBySettingNameOrThrowNotFound(String settingName) {
        return companySettingRepository.findBySettingName(settingName)
                .orElseThrow(() -> new CompanySettingNotFoundException("company setting with setting name "
                        + settingName + " not found"));
    }

    @Override
    public CompanySettingResponse getCompanySetting(String companySettingId) {
        return companySettingRepository.findById(companySettingId)
                .map(companySettingMapper::mapCompanySettingToCompanySettingResponse)
                .orElseThrow(() -> new CompanySettingNotFoundException("company setting with id " + companySettingId + " not found"));
    }
}